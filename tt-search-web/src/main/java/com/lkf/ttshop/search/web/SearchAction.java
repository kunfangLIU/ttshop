package com.lkf.ttshop.search.web;

import com.lkf.ttshop.pojo.vo.TbSearchItemResult;
import com.lkf.ttshop.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: Administrator
 * Date: 2017/11/3
 * Time: 20:57
 * Version:V1.0
 */
@Controller
public class SearchAction {
    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/")
    public String searchItemList(String keyword,
                                 @RequestParam(defaultValue = "1") Integer page, Model model) throws Exception {

        if (keyword != null) {
            keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
            //查询商品列表
            TbSearchItemResult searchResult = searchItemService.search(keyword, page, 60);
            //把结果传递给页面
            model.addAttribute("query", keyword);
            model.addAttribute("totalPages", searchResult.getTotalPages());
            model.addAttribute("page", page);
            model.addAttribute("recourdCount", searchResult.getRecordCount());
            model.addAttribute("itemList", searchResult.getItemList());

        }

        //返回逻辑视图
        return "search";
    }
}
