<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/11/15
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="layui/layui.js"></script>
<body>
<div style="width: 450px; margin: 15px ;border:3px #CCCCCC solid; border-radius: 3px">
    <h1 style="color: #009688 ;margin: 10px">个人信息</h1>
    <hr>
    <form class="layui-form layui-form-pane" action="from.html">
        <div class="layui-form-item">
            <label class="layui-form-label">照片</label>
            <div class="layui-input-inline">
                <img src="img/tou.png" style="width: 120px;height: 120px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled" value="${xs.xh}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled" value="${xs.xm}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled" value="${xs.xb==1?"男":"女"}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled" value="${xs.cssj}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">总学分</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled" value="${xs.zxf}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text"  lay-verify="required"  autocomplete="off" disabled="disabled" value="${xs.bz}" class="layui-input">
            </div>
        </div>

    </form>
</div>
</body>
</html>
