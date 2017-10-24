package com.lkf.ttshop.service;

import com.lkf.common.dto.TreeNode;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/24
 * Time: 11:04
 * Version:V1.0
 * 商品类别实体类接口
 */
public interface ItemCatService {
    List<TreeNode> listItemCats(Long parentId);
}

