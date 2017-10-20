package com.lkf.ttshop.pojo.vo;

import com.lkf.ttshop.pojo.po.TbItem;

/**
 * User: Administrator
 * Date: 2017/10/18
 * Time: 22:02
 * Version:V1.0
 * 商品对应页面的实体类
 */
public class TbItemCustom extends TbItem {
    //也就是页面显示的是商品名称
    private String catName;
    //所属状态别名
    private String statusName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
