package com.lkf.ttshop.service;

import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.pojo.vo.TbItemParamCustom;

/**
 * User: Administrator
 * Date: 2017/10/25
 * Time: 10:58
 * Version:V1.0
 */
public interface ItemParamService {
    /**
     * 查询添加规格参数列表到页面
     * @param page
     * @return
     */
    Result<TbItemParamCustom> listItemParams(Page page);

    /**
     * 添加规格参数
     * @param cid
     * @param paramData
     * @return
     */
    int saveItemParam(Long cid, String paramData);
}
