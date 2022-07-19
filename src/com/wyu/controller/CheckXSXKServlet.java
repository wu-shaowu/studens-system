package com.wyu.controller;

import com.wyu.pojo.XS;
import com.wyu.service.KCBService;
import com.wyu.service.KCBServiceImp1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckXSXKServlet")
public class CheckXSXKServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kch =request.getParameter("kch");
        int xh =  ((XS)request.getSession().getAttribute("xs")).getXh();


        KCBService kcb = new KCBServiceImp1();
        int i =kcb.checkXSXK(xh,kch);

        response.getWriter().append(i+"");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}