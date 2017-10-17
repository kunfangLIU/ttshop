<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <script>
        $('#table').datagrid({
            url:'items',
            columns:[[
                {field:'id',title:'商品ID'},
                {field:'title',title:'商品名称'},
                {field:'sellPoint',title:'卖点'}
            ]]
        });
    </script>
<head>
<body>


</body>
</head>
</html>
