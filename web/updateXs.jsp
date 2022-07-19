<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/12/12
  Time: 22:16
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
<div style="width: 450px; margin: 15px ;border:3px #CCCCCC solid; border-radius: 3px">
    <h1 style="color: #009688 ;margin: 10px">个人信息</h1>
    <hr>
    <form class="layui-form layui-form-pane" action="from.html">

        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">专业</label>
            <div class="layui-input-inline">
                <select name="interest" lay-filter="aihao">
                    <option value=""></option>
                    <option value="0">软件工程</option>
                    <option value="1" selected="">大数据</option>
                    <option value="2">计科</option>
                    <option value="3">音乐</option>
                    <option value="4">旅行</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">总学分</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">头像</label>
            <div class="layui-input-inline">
                <img src="img/tou.png" style="width: 120px;height: 120px">
            </div>
        </div>

        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="demo2">确认修改</button>
        </div>

    </form>
</div>
</body>
</html>
