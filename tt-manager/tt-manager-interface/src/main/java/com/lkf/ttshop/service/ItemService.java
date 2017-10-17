package com.lkf.ttshop.service;

import com.lkf.ttshop.pojo.po.TbItem;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/17
 * Time: 10:33
 * Version:V1.0
 */
public interface ItemService {
      TbItem getById(Long itemId);
      List<TbItem> listItems();
}

