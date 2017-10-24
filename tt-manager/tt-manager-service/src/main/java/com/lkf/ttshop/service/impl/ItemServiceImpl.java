package com.lkf.ttshop.service.impl;

import com.lkf.common.dto.Order;
import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.common.util.IDUtils;
import com.lkf.ttshop.dao.TbItemCatMapper;
import com.lkf.ttshop.dao.TbItemCustomMapper;
import com.lkf.ttshop.dao.TbItemDescMapper;
import com.lkf.ttshop.dao.TbItemMapper;
import com.lkf.ttshop.pojo.po.TbItem;
import com.lkf.ttshop.pojo.po.TbItemDesc;
import com.lkf.ttshop.pojo.po.TbItemExample;
import com.lkf.ttshop.pojo.vo.TbItemCustom;
import com.lkf.ttshop.pojo.vo.TbItemQuery;
import com.lkf.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private TbItemDescMapper tbItemDescDao;
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
  public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query) {
      Map<String,Object> map = new HashMap<String, Object>();
      map.put("page",page);
      map.put("order",order);
      map.put("query",query);
      //通过itemDaoCustom查询出total，查询所有商品数量，没有附加条件
      long total = tbItemMapperCustom.countItems(map);
      List<TbItemCustom> rows = tbItemMapperCustom.listItemsByPage(map);
      //通过itemDaoCustom查询出rows
      Result<TbItemCustom> rs = new Result<TbItemCustom>();
      rs.setTotal(total);
      rs.setRows(rows);
      return rs;
  }

    @Override
    public int updateItemsByIds(byte b,List<Long> ids) {
        //创建商品的空对象
        TbItem item = new TbItem();
        item.setStatus(b);
        //下面的三行只是准备查询的条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        //真正的执行查询
        return itemDao.updateByExampleSelective(item, example);
    }

    /**
     * 保存商品和商品描述
     * @param tbItem
     * @param desc
     * @return
     */
    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String desc) {
        //通过工具类获取到商品id
        long itemId = IDUtils.getItemId();
        //存商品表，tbItem传进来时已经携带了6个属性
        tbItem.setId(itemId);
        tbItem.setStatus((byte)1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        //存商品
        int count = itemDao.insert(tbItem);
        //存商品描述表
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        count += tbItemDescDao.insert(tbItemDesc);
        return count;
    }

}
