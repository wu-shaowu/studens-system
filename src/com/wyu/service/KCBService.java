package com.wyu.service;

import com.wyu.pojo.KCB;

import java.util.List;

public interface KCBService {
    //查询所有课程
    List<KCB> selectByKCBpage(String page, String limit);
  //查询总记录树
    int getCount();
    //查询个人课程
    List<KCB> selectKCBByXh(int xh,String page, String limit);
    //查询记录喝学生
    int getCountAndxh(int xh);
    //检查学生以选修课程无
    int checkXSXK(int xh, String kch);
}
