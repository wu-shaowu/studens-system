<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/11/15
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<div class="layui-btn-group demoTable">
    <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
    <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
    <button class="layui-btn" data-type="isAll">验证是否全选</button>
</div>

<table class="layui-table" lay-data="{width: 1500, height:500, url:'${pageContext.request.contextPath}/SelectXsServiet', page:true, id:'idTest'}" lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'xh', width:'10%', sort: true, fixed: true}">学号</th>
        <th lay-data="{field:'xm', width:'10%'}">姓名</th>
        <th lay-data="{field:'cssj', width:'10%'}">出生日期</th>
        <th lay-data="{field:'zym', width:'15%'}">专业名</th>
        <th lay-data="{field:'zxf', width:'10%',edit:true}">总学分</th>
        <th lay-data="{field:'bz', width:'10%',edit:true}">备注</th>
        <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
    </tr>

    </thead>
</table>

<script type="text/html" id="barDemo">

    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="info">查看</a>
    <a class="layui-btn layui-btn-xs " lay-event="update">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['table','jquery','layer'], function(){
        var table = layui.table;
        var $ = layui.jquery;
        var layer = layui.layer;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除行么《'+ data.xm +'》吗?<br><br>删除后与'+data.xm+'相关的所有信息将被删除，请谨慎操作！！', function(index){
                    var json = {"xh":data.xh};
                    $.post("DeleteXsServlet",json,function (data,stateCode) {
                        if (data == "0"){
                            layer.msg("恭喜。删除成功！",{icon:1});
                        }else {

                            layer.msg("对不起删除失败！",{icon:5});
                        }
                    })

                    obj.del();
                    layer.close(index);
                });
            }
            else if (obj.event === 'info'){

                //多窗口模式，层叠置顶
                layer.open({
                    type: 1 //此处以iframe举例
                    ,title: '《'+data.xm+'》的详细信息'
                    ,area: ['390px', '460px']
                    ,shade: 0
                    ,maxmin: true

                    ,content: '<div style="padding: 15px;">'+
                        '学号：'+data.xh+'<br><br>' +
                        '姓名：'+data.xm+'<br><br>' +
                        '生日：'+data.cssj+'<br><br>' +
                        '总学分：'+data.zxf+'<br><br>' +
                        '专业：'+data.zym+'<br><br>' +
                        '备注：'+data.bz+'<br><br>' +

                        '</div>'

                    ,btn: [ '关闭'] //只是为了演示

                    ,btn2: function(){
                        layer.close();
                    }

                    ,zIndex: layer.zIndex //重点1
                    ,success: function(layero, index){
                        layer.setTop(layero); //重点2. 保持选中窗口置顶

                        //记录索引，以便按 esc 键关闭。事件见代码最末尾处。
                        layer.escIndex = layer.escIndex || [];
                        layer.escIndex.unshift(index);
                        //选中当前层时，将当前层索引放置在首位
                        layero.on('mousedown', function(){
                            var _index = layer.escIndex.indexOf(index);
                            if(_index !== -1){
                                layer.escIndex.splice(_index, 1); //删除原有索引
                            }
                            layer.escIndex.unshift(index); //将索引插入到数组首位
                        });
                    }

                });


            }else if (obj.event === 'update'){
                //多窗口模式，层叠置顶
                layer.open({
                    type: 1 //此处以iframe举例
                    ,title: '修改《'+data.xm+'》'
                    ,area: ['530px', '700px']
                    ,shade: 0
                    ,maxmin: true

                    ,content: '<div style="padding: 15px;">'+
                        '<iframe src="updateXs.jsp" width="100%" height="100%"></iframe>' +
                        '</div>'

                    ,btn: [ '关闭'] //只是为了演示

                    ,btn2: function(){
                        layer.close();
                    }

                    ,zIndex: layer.zIndex //重点1
                    ,success: function(layero, index){
                        layer.setTop(layero); //重点2. 保持选中窗口置顶

                        //记录索引，以便按 esc 键关闭。事件见代码最末尾处。
                        layer.escIndex = layer.escIndex || [];
                        layer.escIndex.unshift(index);
                        //选中当前层时，将当前层索引放置在首位
                        layero.on('mousedown', function(){
                            var _index = layer.escIndex.indexOf(index);
                            if(_index !== -1){
                                layer.escIndex.splice(_index, 1); //删除原有索引
                            }
                            layer.escIndex.unshift(index); //将索引插入到数组首位
                        });
                    }

                });


            }
        });


        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>
