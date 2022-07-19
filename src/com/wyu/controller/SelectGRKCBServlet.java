package com.wyu.controller;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.KCB;
import com.wyu.pojo.XS;
import com.wyu.service.KCBService;
import com.wyu.service.KCBServiceImp1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectGRKCBServlet")
public class SelectGRKCBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page =request.getParameter("page");
        String limit =request.getParameter("limit");
        System.out.println("当前页："+page+"查询的条数"+limit);
        KCBService kService =new KCBServiceImp1();
         int xh = ((XS)request.getSession().getAttribute("xs")).getXh();

        List<KCB> list =kService.selectKCBByXh(xh,page,limit);

        String listjon = JSON.toJSONString(list);

        int count = kService.getCountAndxh(xh);
        String json ="{\"code\": 0,\"msg\": \"\",\"count\": " +count+",\"data\":"+listjon+"}";

        System.out.println(json);
        response.getWriter().append(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}