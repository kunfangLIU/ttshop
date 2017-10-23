package com.lkf.ttshop.pojo.vo;

/**
 * User: Administrator
 * Date: 2017/10/23
 * Time: 20:07
 * Version:V1.0
 * 商品查询的实体类
 */
public class TbItemQuery {
    private String title;
    private byte status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
