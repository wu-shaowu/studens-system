package com.wyu.dao;

import com.wyu.pojo.KCB;

import java.util.List;

public interface KCBDao {


     List<KCB> selectByXhAndKch(int xh, String kch) ;


    List<KCB> selectBypage(int start, int count);

    int selectByCount();

    List<KCB> selectBypageGRKC(int xh , int start, int count);

    int selectByCountAndxh(int xh);
}
