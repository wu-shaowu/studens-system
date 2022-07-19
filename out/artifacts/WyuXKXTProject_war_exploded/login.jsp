<%--
  Created by IntelliJ IDEA.
  User: Jeffery
  Date: 2021/11/7
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0 auto;
            padding: 0;
        }

        body {
            background: url("img/bg.png") no-repeat;
            background-size: cover;
            margin-top: 170px;
            color: #0074BB;

        }

        #div1 {
            text-align: center;
            width: 500px;
            height: 400px;
            background-color: #FFFFFF;
            border-radius: 10px;
        }

        #div1_div1 {
            height: 80px;
            line-height: 80px;
            font-size: 26px;
            color: #0074BB;
            font-weight: bold;
        }

        table {
            font-size: 13px;
            border-spacing: 5px 24px;
            border-collapse: inherit;
        }

        .input1 {
            width: 260px;
            border-radius: 3px;
            height: 35px;
            border: 1px #0074BB solid;
        }

        .sub {
            width: 90px;
            height: 40px;
            border: none;
            background-color: #0074BB;
            color: #FFFFFF;
            font-size: 16px;
            font-weight: bold;
            border-radius: 3px;
        }

        .sub:hover {
            background-color: #0083CB;
        }

    </style>
</head>
<body>
<div id="div1">
    <div id="div1_div1">后台管理-登录</div>
    <form id="myForm" action="<%--${pageContext.request.contextPath}/--%>LoginServlet" method="post">
        <table>
            <tr>
                <td>账&nbsp;&nbsp;号</td>
                <td><input type="text" name="xh" class="input1"></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;码</td>
                <td><input type="password" name="mm" class="input1"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td style="position: relative"><input type="text" name="checkcode" class="input1" style="width: 100px">
                    <a href="javascript:(0)" onclick="shuaxin()"> <img id="img1" src="CodeUtil"
                                                                       style="width: 100px;height: 35px;border: 1px #000000 solid;position: absolute;left: 110px"></a>
                    <a href="javascript:(0)"
                       style="position: absolute;right: -44px;top:15px;font-size: 12px;text-decoration: none"
                       onclick="shuaxin()">看不清,换一张</a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="登&nbsp;&nbsp;录" class="sub"></td>
            </tr>
            <tr>
                <td></td>
                <td><span style="color: red;font-size: 12px">${loginMsg}</span></td>
            </tr>
        </table>
    </form>


</div>

</body>
<script>

    //刷新函数
    function shuaxin() {
        //获得图片
        var img1 = document.getElementById("img1");
        //修改属性
        img1.setAttribute("src","CodeUtil?"+new Date().getTime());
    }
</script>
</html>
