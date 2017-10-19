package com.lkf.ttshop.service.impl;

import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.dao.TbItemCustomMapper;
import com.lkf.ttshop.dao.TbItemMapper;
import com.lkf.ttshop.pojo.po.TbItem;
import com.lkf.ttshop.pojo.vo.TbItemCustom;
import com.lkf.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/17
 * Time: 10:36
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper tbItemMapperCustom;
    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public List<TbItem> listItems() {
        return itemDao.selectByExample(null);
    }


  /*  @Override
    public Result<TbItem> listItems(Page page) {
        //通过itemDaoCustom查询出total，查询所有商品数量，没有附加条件
        long total = tbItemMapperCustom.countItems();
        List<TbItem> rows = tbItemMapperCustom.listItemsByPage(page);
        //通过itemDaoCustom查询出rows
        Result<TbItem> rs = new Result<TbItem>();
        rs.setTotal(total);
        rs.setRows(rows);
        return rs;
    }*/
  @Override
  public Result<TbItemCustom> listItems(Page page) {
      //通过itemDaoCustom查询出total，查询所有商品数量，没有附加条件
      long total = tbItemMapperCustom.countItems();
      List<TbItemCustom> rows = tbItemMapperCustom.listItemsByPage(page);
      //通过itemDaoCustom查询出rows
      Result<TbItemCustom> rs = new Result<TbItemCustom>();
      rs.setTotal(total);
      rs.setRows(rows);
      return rs;
  }
}