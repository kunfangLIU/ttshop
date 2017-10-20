package com.lkf.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/20
 * Time: 17:12
 * Version:V1.0
 * 添加排序实体类
 */
public class Order {
    private String sort;
    private String order;
    private String orderParams;

    public void setOrderParams(String orderParams) {
        this.orderParams = orderParams;
    }

    public List<String> getOrderParams(){
        String[] sorts = this.sort.split(",");
        String[] order = this.order.split(",");
        List<String> list = new ArrayList<String>();
        for (int i = 0;i<sorts.length;i++){
            String temp  = sorts[i]+" "+order[i];//id asc,title desc
            list.add(temp);
        }
        return  list;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
