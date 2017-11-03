package com.lkf.ttshop.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

//	@Autowired
//	private ContentService contentService;
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		
//		//查询内容列表
//		List<TbContent> ad1List = contentService.getContentListByCid(PropKit.use("resource.properties").getLong("CONTENT_LUNBO_ID"));
//		// 把结果传递给页面
//		model.addAttribute("ad1List", ad1List);
		
		return "index";
	}
}