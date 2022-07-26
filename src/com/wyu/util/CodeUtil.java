package com.wyu.util;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CodeUtil")
public class CodeUtil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100,4,20);

//图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write(response.getOutputStream());
       /* System.out.println("产生的验证码"+lineCaptcha.getCode());*/
        String code = lineCaptcha.getCode();
        System.out.println("产生的验证码"+code);
        //在产生验证码的时候，要将验证码保存到seesion中，为了给后面的页面获取然后验证
        request.getSession().setAttribute("code",code);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}