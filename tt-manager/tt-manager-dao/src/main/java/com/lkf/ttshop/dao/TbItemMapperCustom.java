package com.lkf.ttshop.dao;

import com.lkf.common.dto.Page;
import com.lkf.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/10/18
 * Time: 19:12
 * Version:V1.0
 */
/*public interface TbItemMapperCustom {
    List<TbItem> listItemsByPage(Page page);
    long countItems();
}*/
public interface TbItemMapperCustom {
    List<TbItemCustom> listItemsByPage(Page page);
    long countItems();
}
