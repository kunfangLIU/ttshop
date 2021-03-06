package com.lkf.ttshop.web;

import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.pojo.vo.TbItemParamCustom;
import com.lkf.ttshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Administrator
 * Date: 2017/10/25
 * Time: 10:53
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemParamAction {
    @Autowired
    private ItemParamService itemParamService;

    /**
     * 添加规格参数的数据查询展示到页面控制层
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParams(Page page){
        return  itemParamService.listItemParams(page);
    }

    /**
     * 添加规格参数的参数添加与保存控制层
     * @param cid
     * @param paramData
     * @return
     */
    @ResponseBody
    @RequestMapping("itemParam/{cid}")
    public int saveItemParam(@PathVariable("cid") Long cid, @RequestParam("paramData")String paramData){
       int count =  itemParamService.saveItemParam(cid,paramData);
       return  count;
    }
}
