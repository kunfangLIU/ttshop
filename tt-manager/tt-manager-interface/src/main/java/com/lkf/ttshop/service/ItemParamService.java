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
    Result<TbItemParamCustom> listItemParams(Page page);

    int saveItemParam(Long cid, String paramData);
}
