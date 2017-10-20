package com.lkf.ttshop.service;

import com.lkf.common.dto.Order;
import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.pojo.po.TbItem;
import com.lkf.ttshop.pojo.vo.TbItemCustom;

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

    Result<TbItemCustom> listItems(Page page, Order order);


    /**
     * 通过商品编号批量修改
     * @param ids
     * @return
     */
    int updateItemsByIds(List<Long> ids);
}

