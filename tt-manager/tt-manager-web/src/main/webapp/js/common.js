
var ttshop = {
    //点击左侧导航树上的节点响应事件
    registerMenuEvent:function(){
        var _this = this;
        $("#menu .easyui-tree").tree({
            onClick:function(node){
                //node.attributes.href 返回你点击的那个节点的href
                var href = node.attributes.href;
                var text = node.text;
                _this.addTabs(text,href);
            }
        });
    },
    //添加选项卡事件
    addTabs:function(text,href){
        if ($('#tab').tabs('exists',text)){
            $('#tab').tabs('select',text)
        }else{
            $('#tab').tabs('add',{
                //选项卡的标题
                title:text,
                //就是选项卡的内容的链接地址（请求地址）
                href:href,
                //该选项卡可以被关闭
                closable:true,
            });
        }
    }

};



