package com.lkf.ttshop.dao;

import com.lkf.ttshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/10/25
 * Time: 11:10
 * Version:V1.0
 */
public interface TbItemParamCustomMapper {
    List<TbItemParamCustom> listItemParamsByPage(Map<String, Object> map);

    long countItemParams(Map<String, Object> map);
}
