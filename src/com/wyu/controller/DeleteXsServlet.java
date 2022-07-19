package com.wyu.controller;

import com.wyu.service.XSService;
import com.wyu.service.XSServiceImp1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteXsServlet")
public class DeleteXsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xh =request.getParameter("xh");
        System.out.println("删除的学号："+xh);
        XSService service = new XSServiceImp1();
        int i = service.deletebyXh(xh);
        response.getWriter().append(i+"");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}