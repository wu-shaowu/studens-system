package com.wyu.controller;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.XS;
import com.wyu.service.XSService;
import com.wyu.service.XSServiceImp1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectXsServiet")
public class SelectXsServiet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String page =request.getParameter("page");
            String limit =request.getParameter("limit");
            System.out.println("当前页："+page+"查询的条数"+limit);
            XSService service =new XSServiceImp1();
            List<XS> list =service.selectXSAll(page,limit);

            String listjon = JSON.toJSONString(list);

            int count = service.getCount();
            String json ="{\"code\": 0,\"msg\": \"\",\"count\": " +count+",\"data\":"+listjon+"}";

            System.out.println(json);
            response.getWriter().append(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}