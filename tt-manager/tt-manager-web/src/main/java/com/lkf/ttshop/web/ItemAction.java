package com.lkf.ttshop.web;

import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.pojo.po.TbItem;
import com.lkf.ttshop.pojo.vo.TbItemCustom;
import com.lkf.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
   /* @RequestMapping("/items")
    @ResponseBody
    public List<TbItem> listItems() {
        return itemService.listItems();
    }*/

  /*  @ResponseBody
    @RequestMapping("/items")
    public Result<TbItem> listItems(Page page){
        return itemService.listItems(page);
    }*/
  @ResponseBody
  @RequestMapping("/items")
  public Result<TbItemCustom> listItems(Page page){
      return itemService.listItems(page);
  }
}
