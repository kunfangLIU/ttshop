package com.lkf.ttshop.web;

import com.lkf.common.dto.MessageResult;
import com.lkf.ttshop.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Administrator
 * Date: 2017/11/3
 * Time: 19:47
 * Version:V1.0
 */
@Controller
public class SearchItemAction {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/search/item/import")
    @ResponseBody
    public MessageResult importItemList() throws Exception {

        searchItemService.importAllItems();

        MessageResult ms = new MessageResult();
        ms.setSuccess(true);
        ms.setMessage("索引导入成功");
        return ms;
    }
}
