package com.lkf.ttshop.service.impl;

import com.lkf.common.dto.Page;
import com.lkf.common.dto.Result;
import com.lkf.ttshop.dao.TbItemParamCustomMapper;
import com.lkf.ttshop.dao.TbItemParamMapper;
import com.lkf.ttshop.pojo.po.TbItemParam;
import com.lkf.ttshop.pojo.vo.TbItemParamCustom;
import com.lkf.ttshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/10/25
 * Time: 11:00
 * Version:V1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Autowired
    private TbItemParamCustomMapper tbItemParamMapperCustom;

    @Override
    public Result<TbItemParamCustom> listItemParams(Page page) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("page", page);
        List<TbItemParamCustom> list = tbItemParamMapperCustom.listItemParamsByPage(map);
        long counts = tbItemParamMapperCustom.countItemParams(map);
        Result<TbItemParamCustom> rs = new Result<TbItemParamCustom>();
        rs.setTotal(counts);
        rs.setRows(list);
        return rs;
    }

    @Override
    public int saveItemParam(Long cid, String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setUpdated(new Date());
        tbItemParam.setCreated(new Date());
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramData);
        return tbItemParamMapper.insert(tbItemParam);
    }
}
