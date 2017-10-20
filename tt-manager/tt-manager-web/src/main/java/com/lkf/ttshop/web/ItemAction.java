package com.lkf.ttshop.web;

import com.lkf.common.dto.Order;
import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.pojo.po.TbItem;
import com.lkf.ttshop.pojo.vo.TbItemCustom;
import com.lkf.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    ItemService itemService;

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
  public Result<TbItemCustom> listItems(Page page, Order order){
      return itemService.listItems(page,order);
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
}
