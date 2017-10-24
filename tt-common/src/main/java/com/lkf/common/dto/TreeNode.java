package com.lkf.common.dto;

/**
 * User: Administrator
 * Date: 2017/10/24
 * Time: 10:58
 * Version:V1.0
 * 树节点结构实体类
 */
public class TreeNode {
    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
