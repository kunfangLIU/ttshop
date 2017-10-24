package com.lkf.ttshop.service;

import com.lkf.common.dto.Order;
import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.pojo.po.TbItem;
import com.lkf.ttshop.pojo.vo.TbItemCustom;
import com.lkf.ttshop.pojo.vo.TbItemQuery;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/17
 * Time: 10:33
 * Version:V1.0
 */
public interface ItemService {
      /**
       * 按主键查询指定商品
       * @param itemId
       * @return
       */
      TbItem getById(Long itemId);

      /**
       * 不带分页的查询所有商品
       * @return
       */
      List<TbItem> listItems();

    /**
     * 带分页查询所有商品
     * @param page
     * @return
     */

 //   Result<TbItem> listItems(Page page);

    Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query);


    /**
     * 通过商品编号批量修改的状态
     * @param ids
     * @return
     */
    int updateItemsByIds(byte b,List<Long> ids);

    /**
     * 保存商品和商品描述
     * @param tbItem
     * @param content
     * @return
     */
    int saveItem(TbItem tbItem, String content);
}

