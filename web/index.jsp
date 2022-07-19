<%--
  Created by IntelliJ IDEA.
  User: 23797
  Date: 2021/11/7
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <!-- 引入 layui.css -->
    <link rel="stylesheet" href="layui/css/layui.css">

    <!-- 引入 layui.js -->
    <script src="layui/layui.js"></script>
    <style>
      .ji{
        padding-left: 30px;
      }
    </style>
      </head>

  <body>
  <div class="layui-layout layui-layout-admin">

    <div class="layui-header ">
      <div class="layui-logo layui-hide-xs layui-bg-black" style="font-size: 25px;font-family: 楷体">选课系统</div>

      <!-- 头部区域（可配合layui 已有的水平导航） -->
      <ul class="layui-nav layui-layout-left">
        <li class=" layui-hide-xs"><a href="https://www.wyu.edu.cn/" target="_blank"><img src="img/logo.png" height="55px"></a></li>

      </ul>
      <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item layui-hide layui-show-md-inline-block">
          <a href="javascript:;">
            <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
            ${xs.xm}
          </a>
          <dl class="layui-nav-child">
            <dd><a href="">学号：${xs.xh}</a></dd>
            <dd><a href="">姓名：${xs.xm}</a></dd>
            <dd><a href="">性别：${xs.xb}</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/Logout">退出</a></li>
        <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
          <a href="javascript:;">
            <i class="layui-icon layui-icon-more-vertical"></i>
          </a>
        </li>
      </ul>
    </div>

    <div class="layui-side layui-bg-black">
      <div class="layui-side-scroll">
        <center>
        <img src="/img/tou.png" class="layui-nav-img" style="width: 130px;height: 130px;margin-top: 20px">
        <p style="margin-top: 15px;">欢迎:${xs.xm}</p>
          <hr>
        </center>

        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
          <li class="layui-nav-item layui-nav-itemed" style="display: ${xs.bz=="1"?"none":"block"}">
            <a class="" href="javascript:;"><i class="layui-icon layui-icon-friends" style="font-size: 18px;font-weight: bold;  color: #1E9FFF;"></i>&nbsp;&nbsp;&nbsp;&nbsp;学生选项</a>
            <dl class="layui-nav-child">
              <dd class="ji"><a href="javascript:;"
                                data-url="grxx.jsp"
                                data-id="grxx"
                                data-title="<i class='layui-icon layui-icon-search'
style='font-size: 20px; color: #1E9FFF;'></i>&nbsp;&nbsp;查询个人信息"
                                class="site-demo-active"
                                data-type="tabAdd"


              ><i class="layui-icon-search" style="font-size: 18px;font-weight: bold;  color: #1E9FFF;"></i>&nbsp;&nbsp;&nbsp;查询个人信息</a></dd>
              <dd class="ji"><a href="javascript:;"
                                data-url="xkqk.jsp"
                                data-id="xkqk"
                                data-title="<i class='layui-icon layui-icon-username'
style='font-size: 20px; color: #1E9FFF;'></i>&nbsp;&nbsp;个人选课情况"
                                class="site-demo-active"
                                data-type="tabAdd"



              ><i class="layui-icon layui-icon-username" style="font-size: 18px;font-weight: bold;  color: #1E9FFF;"></i>&nbsp;&nbsp;&nbsp;个人选课情况</a></dd>
              <dd class="ji"><a href="javascript:;"
                                data-url="sykc.jsp"
                                data-id="sykc"
                                data-title="<i class='layui-icon layui-icon-survey'
style='font-size: 20px; color: #1E9FFF;'></i>&nbsp;&nbsp;查询所有课程"
                                class="site-demo-active"
                                data-type="tabAdd"


              ><i class="layui-icon layui-icon-survey" style="font-size: 18px;font-weight: bold;  color: #1E9FFF;"></i>&nbsp;&nbsp;&nbsp;查询所有课程</a></dd>

            </dl>
          </li>
          <li class="layui-nav-item" style="display: ${xs.bz=="1"?"block":"none"}">
            <a href="javascript:;"><i class="layui-icon layui-icon-group" style="font-size: 18px;font-weight: bold;  color: #1E9FFF;"></i>&nbsp;&nbsp;&nbsp;管理选项</a>
            <dl class="layui-nav-child">
              <dd class="ji"><a href="javascript:;"
                                data-url="xsgl.jsp"
                                data-id="xsgl"
                                data-title="<i class='layui-icon layui-icon-console'
style='font-size: 20px; color: #1E9FFF;'></i>&nbsp;&nbsp;学生管理"
                                class="site-demo-active"
                                data-type="tabAdd"


              ><i class="layui-icon layui-icon-console" style="font-size: 18px;font-weight: bold;  color: #1E9FFF;"></i>&nbsp;&nbsp;&nbsp;学生管理</a></dd>
              <dd class="ji"><a href="javascript:;"
                                data-url="zygl.jsp"
                                data-id="zygl"
                                data-title="<i class='layui-icon layui-icon-template-1'
style='font-size: 20px; color: #1E9FFF;'></i>&nbsp;&nbsp;专业管理"
                                class="site-demo-active"
                                data-type="tabAdd"


              ><i class="layui-icon layui-icon-template-1" style="font-size: 18px;font-weight: bold;  color: #1E9FFF;"></i>&nbsp;&nbsp;&nbsp;专业管理</a></dd>
              <dd class="ji"><a href="javascript:;"
                                data-url="kcgl.jsp"
                                data-id="kcgl"
                                data-title="<i class='layui-icon layui-icon-spread-left'
style='font-size: 20px; color: #1E9FFF;'></i>&nbsp;&nbsp;课程管理"
                                class="site-demo-active"
                                data-type="tabAdd"


              ><i class="layui-icon layui-icon-spread-left" style="font-size: 18px;font-weight: bold;  color: #1E9FFF;"></i>&nbsp;&nbsp;&nbsp;课程管理</a></dd>

            </dl>
          </li>

        </ul>
      </div>
    </div>

    <div class="layui-body">
      <!-- 内容主体区域 -->
      <div style="padding: 5px;">
        <div class="layui-tab layui-tab-card" lay-filter="demo" lay-allowclose="true">
          <ul class="layui-tab-title">
            <li class="layui-this"><i class="layui-icon layui-icon-home"
                                      style="font-size: 20px; color: #1E9FFF; font-weight: bold"></i>&nbsp;&nbsp;学校首页
            </li>

          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
              <iframe src="XXindex.jsp" width="100%" height="500px"></iframe>
            </div>

          </div>


        </div>




      </div>
    </div>

    <div class="layui-footer">
      <!-- 底部固定区域 -->
      底部固定区域
    </div>
  </div>
  <script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
      var element = layui.element
              ,layer = layui.layer
              ,util = layui.util
              ,$ = layui.$;

      //头部事件
      util.event('lay-header-event', {
        //左侧菜单事件
        menuLeft: function(othis){
          layer.msg('展开左侧菜单的操作', {icon: 0});
        }
        ,menuRight: function(){
          layer.open({
            type: 1
            ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
            ,area: ['260px', '100%']
            ,offset: 'rt' //右上角
            ,anim: 5
            ,shadeClose: true
          });
        }
      });


      //触发事件
      var active = {
        //在这里给active绑定几项事件，后面可通过active调用这些事件
        tabAdd: function (url, id, title) {
          //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
          //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
          element.tabAdd('demo', {
            title: title,
            content: '<iframe data-frameid="' + id
                    + '" scrolling="auto" frameborder="0" src="'
                    + url + '" style="width:100%;height: 730px"></iframe>',
            id: id
            //规定好的id
          })
          element.render('tab');

        },
        tabChange: function (id) {
          //切换到指定Tab项
          element.tabChange('demo', id); //根据传入的id传入到指定的tab项
        },
        tabDelete: function (id) {
          element.tabDelete("demo", id);//删除
        },
        tabDeleteAll: function (ids) {//删除所有
          $.each(ids, function (i, item) {
            element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
          })
        }
      };
//当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
      $('.site-demo-active').on(
              'click',
              function () {
                var dataid = $(this);

                //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
                if ($(".layui-tab-title li[lay-id]").length <= 0) {
                  //如果比零小，则直接打开新的tab项
                  active
                          .tabAdd(dataid.attr("data-url"), dataid
                                  .attr("data-id"), dataid
                                  .attr("data-title"));
                } else {
                  //否则判断该tab项是否以及存在

                  var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                  $.each($(".layui-tab-title li[lay-id]"),
                          function () {
                            //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                            if ($(this).attr("lay-id") == dataid
                                    .attr("data-id")) {
                              isData = true;
                            }
                          })
                  if (isData == false) {
                    //标志为false 新增一个tab项
                    active.tabAdd(dataid.attr("data-url"), dataid
                            .attr("data-id"), dataid
                            .attr("data-title"));
                  }
                }
                //最后不管是否新增tab，最后都转到要打开的选项页面上
                active.tabChange(dataid.attr("data-id"));
              });


    });
  </script>
  </body>

</html>
