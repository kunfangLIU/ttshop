package com.lkf.ttshop.service.impl;

import com.lkf.common.dto.TreeNode;
import com.lkf.ttshop.dao.TbItemCatMapper;
import com.lkf.ttshop.pojo.po.TbItemCat;
import com.lkf.ttshop.pojo.po.TbItemCatExample;
import com.lkf.ttshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/24
 * Time: 11:08
 * Version:V1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        //1 创建查询模板
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //2 执行查询
        List<TbItemCat> itemCatList = itemCatDao.selectByExample(example);
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        //3 组合成新的List<TreeNode>
        for (int i = 0; i < itemCatList.size(); i++) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(itemCatList.get(i).getId());
            treeNode.setText(itemCatList.get(i).getName());
            treeNode.setState(itemCatList.get(i).getIsParent() ? "closed" : "open");
            treeNodeList.add(treeNode);
        }
        //4 返回
        return treeNodeList;
    }

}
