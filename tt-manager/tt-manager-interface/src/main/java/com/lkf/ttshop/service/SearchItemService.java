package com.lkf.ttshop.service;

import com.lkf.ttshop.pojo.vo.TbSearchItemResult;

/**
 * User: Administrator
 * Date: 2017/11/3
 * Time: 20:04
 * Version:V1.0
 */
public interface SearchItemService {
    void importAllItems() throws Exception;

    TbSearchItemResult search(String keyword, int page, int rows)  throws Exception;
}
