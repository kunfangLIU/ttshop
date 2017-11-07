package com.lkf.ttshop.message;

import com.lkf.ttshop.dao.TbItemCustomMapper;
import com.lkf.ttshop.pojo.vo.TbSearchItemCustom;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * 监听商品添加消息，接收消息后，将对应的商品信息同步到索引库
 */
public class ItemAddMessageListener implements MessageListener {

	@Autowired
	private TbItemCustomMapper itemMapperCustom;
	@Autowired
	private SolrServer solrServer;

	@Override
	public void onMessage(Message message) {

		try {
			//从消息中取商品id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			Long itemId = new Long(text);
			//等待事务提交
			//根据商品id查询商品信息
			TbSearchItemCustom searchItem = itemMapperCustom.getSearchItemById(itemId);
			//创建一个文档对象
			SolrInputDocument document = new SolrInputDocument();
			//向文档对象中添加域
			document.addField("id", searchItem.getId());
			document.addField("item_title", searchItem.getTitle());
			document.addField("item_sell_point", searchItem.getSellPoint());
			document.addField("item_price", searchItem.getPrice());
			document.addField("item_image", searchItem.getImage());
			document.addField("item_category_name", searchItem.getCatName());
			//把文档写入索引库
			solrServer.add(document);
			//提交
			solrServer.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
