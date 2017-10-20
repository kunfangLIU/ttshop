<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>

<script>
    var toolbar = [{
        iconCls: 'icon-add',
        text: '新增',
        handler: function () {
            console.log('add');
        }
    },{
        iconCls: 'icon-remove',
        text: '删除',
        handler: function () {
            //获取选中的行
            var selectRows = $('#dg').datagrid('getSelections');
            //没有选中任何行
            if(selectRows.length == 0){
                $.messager.alert('提示','未选中记录','warning');
                return;
            }
            //选中至少一行记录
            $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                if (r){
                    //点击了消息窗口上的确认按钮
                    //将选中记录的编号写进一个数组中
                    var ids = [];
                    for(var i=0;i<selectRows.length;i++){
                        ids.push(selectRows[i].id);
                    }
                    //ajax提交数组给后台
                    $.post(
                        //url:提交给后台的哪个动作去处理，只有第一个参数是必选的，其余的都是可选项
                        'items/batch',
                        //data:提交哪些数据给后台进行处理
                        {'ids[]':ids},
                        //function:处理后成功回调的函数
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        //datatype:返回的数据类型
                        'json'
                    );

                }
            });
        }
    },{
        iconCls: 'icon-edit',
        text: '编辑',
        handler: function () {
            console.log('edit');
        }
    },{
        iconCls: 'icon-up',
        text: '上架',
        handler: function () {
            console.log('up');
        }
    },{
        iconCls: 'icon-down',
        text: '下架',
        handler: function () {
            console.log('down');
        }
    }];


    $('#dg').datagrid({
        pageSize:20,
        pageList:[20,40,50],
        toolbar:toolbar,
        fit:true,
        pagination:true,
        url:'items',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'商品编号',width:100},
            {field:'title',title:'商品名称',width:100},
            {field:'sellPoint',title:'商品卖点',width:100},
            {field:'price',title:'商品价格',width:100},
            {field:'num',title:'库存数量',width:100},
            {field:'barcode',title:'商品条形码',width:100},
            {field:'image',title:'商品图片',width:100},
            {field:'catName',title:'所属类目'},
            {field:'status',title:'商品状态',formatter:function(value,row,index){
//                console.group();
//                console.log(value);
//                console.log(row);
//                console.log(index);
//                console.groupEnd();
                switch (value){
                    case 1:
                        return '正常';
                        break;
                    case 2:
                        return '下架';
                        break;
                    case 3:
                        return '删除';
                        break;
                    default:
                        return '未知';
                        break;
                }
            }},
            {field:'created',title:'创建时间',formatter:function(value,row,index){
                return moment(value).format('YYYY,MMMM Do,HH:mm,dddd');
            }},
            {field:'updated',title:'更新时间',formatter:function (value,row,index) {
                return moment(value).format('YYYY,MMMM Do,HH:mm,dddd');
            }}
        ]]
    });

</script>