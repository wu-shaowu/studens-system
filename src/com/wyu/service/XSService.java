package com.wyu.service;

import com.wyu.pojo.XS;

import java.util.List;

public interface XSService {
    //1.登录方法
    XS login(String xh, String mm);
    //查询所有学生的学生分页
    List<XS> selectXSAll(String page, String limit);

    //查询学生的总记录数
    int getCount();


    int deletebyXh(String xh);
}
