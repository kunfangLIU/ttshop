package com.lkf.ttshop.web;

import com.lkf.common.dto.TreeNode;
import com.lkf.ttshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/24
 * Time: 11:20
 * Version:V1.0
 * 商品分类控制层
 */
@Controller
@Scope("prototype")
public class ItemCatAction {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/itemCats", method = RequestMethod.POST)
    @ResponseBody
    public List<TreeNode> listItemCats(@RequestParam("parentId") Long parentId) {
        return itemCatService.listItemCats(parentId);
    }
}

