package com.lkf.ttshop.service.impl;

import com.lkf.ttshop.dao.TbItemCustomMapper;
import com.lkf.ttshop.pojo.vo.TbSearchItemCustom;
import com.lkf.ttshop.service.SearchItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/3
 * Time: 20:05
 * Version:V1.0
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {
    @Autowired
    private TbItemCustomMapper itemMapper;

    @Autowired
    private SolrServer solrServer;



    @Override
    public void importAllItems() throws Exception {
        //一键导入索引库
        //查询商品列表
        List<TbSearchItemCustom> itemList = itemMapper.getSearchItemList();
        //遍历商品列表
        for (TbSearchItemCustom searchItem : itemList) {
            //创建文档对象
            SolrInputDocument document = new SolrInputDocument();
            //向文档对象中添加域：对应schema.xml配置文件中的域名
            //对应：addField的第一个参数跟schema.xml中field name保持一致
            document.addField("id", searchItem.getId());
            document.addField("item_title", searchItem.getTitle());
            document.addField("item_sell_point", searchItem.getSellPoint());
            document.addField("item_price", searchItem.getPrice());
            document.addField("item_image", searchItem.getImage());
            document.addField("item_category_name", searchItem.getCatName());
            //把文档对象写入索引库
            solrServer.add(document);
        }
        //提交
        solrServer.commit();
    }
}