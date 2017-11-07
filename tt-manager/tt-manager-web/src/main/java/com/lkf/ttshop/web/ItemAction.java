package com.lkf.ttshop.web;

import com.lkf.common.dto.MessageResult;
import com.lkf.common.dto.Order;
import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.pojo.po.TbItem;
import com.lkf.ttshop.pojo.vo.TbItemCustom;
import com.lkf.ttshop.pojo.vo.TbItemQuery;
import com.lkf.ttshop.service.ItemService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/17
 * Time: 10:50
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ItemService itemService;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination topicDestination;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem getById(@PathVariable Long itemId){

        return itemService.getById(itemId);
    }

    /**
     * 分页查询
     * @param page
     * @param order
     * @return
     */
  @ResponseBody
  @RequestMapping("/items")
  public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query){
      return itemService.listItems(page,order,query);
  }

    /**
     * 批量删除，其实是把状态为3的隐藏掉
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/items/batch",method = RequestMethod.POST)
    public int updateItemsByIds(@RequestParam("ids[]") List<Long> ids){
        return itemService.updateItemsByIds((byte)3,ids);
    }

    /**
     * 更改上架状态
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/items/up",method = RequestMethod.POST)
    public int uploadItemsByIds(@RequestParam("ids[]") List<Long> ids){
        return itemService.updateItemsByIds((byte)1,ids);
    }
    /**
     * 更改下架状态
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/items/down",method = RequestMethod.POST)
    public int downloadItemsByIds(@RequestParam("ids[]") List<Long> ids){
        return itemService.updateItemsByIds((byte)2,ids);
    }
    /**
     * 保存新商品
     * @param tbItem 为了对应除商品描述以外其他字段
     * @param content 为了对应商品描述
     * @return 受到影响的行数
     */
    @ResponseBody
    @RequestMapping(value = "/item",method = RequestMethod.POST)
    public MessageResult saveItem (TbItem tbItem, String content){
       MessageResult ms = null;
       try {
            final Long itemId = itemService.saveItem(tbItem, content);
            //发送商品添加成功的主题，一对多的消息，发布/订阅模式
           jmsTemplate.send(topicDestination, new MessageCreator() {
               @Override
               public Message createMessage(Session session) throws JMSException {
                   TextMessage message = session.createTextMessage(itemId + "");
                   return message;
               }
           });
           ms = new MessageResult();
           ms.setMessage("新增商品成功");
           ms.setSuccess(true);
       }catch (Exception e){
           logger.error(e.getMessage(),e);
           e.printStackTrace();
       }
        return  ms;
    }
}
