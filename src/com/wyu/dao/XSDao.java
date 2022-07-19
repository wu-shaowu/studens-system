package com.wyu.dao;

import com.wyu.pojo.XS;

import java.util.List;

public interface XSDao {
    //1.通过学号查询这个用户
    XS selectByXh(String xh);

    List<XS> selectBypage(int start, int count);

    int selectCount();

    int deleteXsByXh(String xh);
}
