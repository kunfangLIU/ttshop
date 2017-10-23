package com.lkf.ttshop.dao;

import com.lkf.ttshop.pojo.vo.TbItemCustom;

import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/10/18
 * Time: 19:12
 * Version:V1.0
 */
/*public interface TbItemCustomMapper {
    *//**
     * 分页查询商品集合
     * @param page
     * @return
     *//*
    List<TbItem> listItemsByPage(Page page);

    *//**
     * 查询所有商品的总记录数
     * @return
     *//*
    long countItems();
}*/

public interface TbItemCustomMapper {
    /**
     * 查询所有商品的总记录数
     * @return
     */
    long countItems(Map<String, Object> map);
    /**
     * 分页查询出商品集合
     * @return
     */
    List<TbItemCustom> listItemsByPage(Map<String, Object> map);
}