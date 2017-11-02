<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="itemForm" id="itemAddForm" name="itemAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">商品类目：</td>
                <td>
                    <input id="cid" name="cid" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">商品标题：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="title" name="title"
                           data-options="required:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td class="label">商品卖点：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="sellPoint" name="sellPoint"
                           data-options="validType:'length[0,150]',multiline:true" style="width:100%;height:60px;">
                </td>
            </tr>
            <tr>
                <td class="label">商品价格：</td>
                <td>
                    <input class="easyui-numberbox" type="text" id="priceView" name="priceView"
                           data-options="required:true,min:0,precision:2">
                    <input type="hidden" id="price" name="price">
                </td>
            </tr>
            <tr>
                <td class="label">商品库存：</td>
                <td>
                    <input class="easyui-numberbox" type="text" id="num" name="num"
                           data-options="required:true,min:0,precision:0">
                </td>
            </tr>
            <tr>
                <td class="label">条形码：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="barcode" name="barcode"
                           data-options="validType:'length[0,30]'">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="content" type="text/plain">商品描述fffffff</script>
                </td>
            </tr>

            <tr class="paramsShow" style="display:none;">
                <td class="label">商品规格：</td>
                <td>

                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="submitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="clearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
        <input name="paramData" id="paramData" style="display:none;">
    </form>
</div>

<script>
    //初始化树形下拉框
    $('#cid').combotree({
        url: 'itemCats?parentId=0',
        required: true,
        onBeforeExpand:function(node){
            //首先获取combotree组件中的树，再获取到树中选项
            var options = $('#cid').combotree('tree').tree('options');
            //通过修改url用来点击
            options.url = 'itemCats?parentId=' + node.id;
        },
        onBeforeSelect:function(node){
            //如果是最终的类别返回true，否则返回false
            var isLeaf = $('#cid').tree('isLeaf',node.target);
            if(!isLeaf){
                $.messager.alert('警告','没有选中最终类目','warning');
                return false;
            }
        }
    });
    //初始化百度的富文本编辑器
   // var ue = UE.getEditor('container');
    //实例化富文本编辑器
    //get请求
    //可以初始化修改ueditor.config.js的属性
    var ue = UE.getEditor('container', {
        initialFrameWidth: '100%',
        initialFrameHeight: '300',
        serverUrl:'file/upload'
    });
    //用来提交表单的操作
    function submitForm() {
        $('#itemAddForm').form('submit', {
            //提交给后台处理的URL地址
            url: 'item',
            //提交前的动作，如果返回false阻止提交
            onSubmit: function () {
                //给商品价格隐藏域设值
                $('#price').val($('#priceView').val()*100);
                //this:DOM对象
                //$(this)：jquery对象
                return $(this).form('validate');
            },
            //提交处理成功后的动作
            success: function () {
                console.log('success');
            }
        })
    }
</script>