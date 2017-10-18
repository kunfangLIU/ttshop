package com.lkf.ttshop.service.impl;

import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.dao.TbItemMapper;
import com.lkf.ttshop.dao.TbItemMapperCustom;
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
    private TbItemMapperCustom tbItemMapperCustom;
    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public List<TbItem> listItems() {
        return itemDao.selectByExample(null);
    }

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page) {
        List<TbItemCustom> list = tbItemMapperCustom.listItemsByPage(page);
        long counts = tbItemMapperCustom.countItems();
        Result<TbItemCustom> rs = new Result<TbItemCustom>();
        rs.setRows(list);
        rs.setTotal(counts);
        return rs;
    }

    /*@Override
    public Result<TbItem> listItemByPage(Page page) {
        List<TbItem> list = tbItemMapperCustom.listItemsByPage(page);
        long counts = tbItemMapperCustom.countItems();
        Result<TbItem> rs = new Result<TbItem>();
        rs.setRows(list);
        rs.setTotal(counts);
        return rs;
    }*/



}
