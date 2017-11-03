package com.lkf.ttshop.service.impl;

import com.lkf.ttshop.dao.SearchItemDao;
import com.lkf.ttshop.dao.TbItemCustomMapper;
import com.lkf.ttshop.pojo.vo.TbSearchItemCustom;
import com.lkf.ttshop.pojo.vo.TbSearchItemResult;
import com.lkf.ttshop.service.SearchItemService;
import org.apache.solr.client.solrj.SolrQuery;
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

    @Autowired
    private SearchItemDao searchItemDao;

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
    @Override
    public TbSearchItemResult search(String keyword, int page, int rows) throws Exception {
        //创建一个SolrQuery对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(keyword);
        //设置分页条件
        if (page <=0 ) page = 1;
        query.setStart((page - 1) * rows);
        query.setRows(rows);
        //设置默认搜索域
        query.set("df", "item_keywords");
        //开启高亮显示
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em style=\"color:red\">");
        query.setHighlightSimplePost("</em>");
        //调用dao执行查询
        TbSearchItemResult searchResult = searchItemDao.search(query);
        //计算总页数
        long recordCount = searchResult.getRecordCount();
        int totalPage = (int) (recordCount / rows);
        if (recordCount % rows > 0){
            totalPage ++;
        }
        //添加到返回结果
        searchResult.setTotalPages(totalPage);
        //返回结果
        return searchResult;
    }
}