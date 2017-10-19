<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>

<script>
    $('#dg').datagrid({
        fit:true,
        pagination:true,
        url:'items',
        columns:[[
            {field:'id',title:'商品编号',width:100},
            {field:'title',title:'商品名称',width:100},
            {field:'sellPoint',title:'商品卖点',width:100},
            {field:'price',title:'商品价格',width:100},
            {field:'num',title:'库存数量',width:100},
            {field:'barcode',title:'商品条形码',width:100},
            {field:'image',title:'商品图片',width:100},
            {field:'catName',title:'所属类目',width:100},
            {field:'status',title:'商品状态',width:100},
            {field:'created',title:'创建时间',width:100},
            {field:'updated',title:'更新时间',width:100}

        ]]
    });

</script>