package com.wyu.controller;

import com.wyu.pojo.XS;
import com.wyu.service.XSService;
import com.wyu.service.XSServiceImp1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*    //处理中文乱码问题
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");*/
        //接收用户名密码和验证码
        String xh = request.getParameter("xh");
        String mm = request.getParameter("mm");
        String checkcode = request.getParameter("checkcode");
        System.out.println("验证码"+checkcode+",用户名："+xh+",密码"+mm);

        //验证验证码是否正确
        //思路：获取用户输入的，之前保存的session中的比较两个是否一样
        String code = request.getSession().getAttribute("code")+"";
        HttpSession session = request.getSession();
        if(!checkcode.equals(code)){
            //跳转到登录页面，提示信息
            //保存提示信息
            session.setAttribute("loginMsg","验证码错误");
            //重定向到登录界面;
            response.sendRedirect("login.jsp");
            /*request.getSession().setAttribute("loginMsg","");//设置为空，不设置会卡主错误验证码*/
            return;//结束
        }
        //判断用户名和密码是否正确
        //用三层架构写项目，service，dao和web(controller)
        //将xh和mm交给service层做逻辑处理
        XSService xsService = new XSServiceImp1();
        XS xs = xsService.login(xh,mm);
        if (xs !=null){
            //登录成功
            //将学生对象保存到seesion中，跳转到首页
            session.setAttribute("xs",xs);
            //将登录提示置空
            session.setAttribute("loginMsg","");
            response.sendRedirect("index.jsp");
            return;
        }



        //登录失败
        session.setAttribute("loginMsg","用户名或密码错误");
        //重定向到登录界面;
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}