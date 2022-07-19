package com.wyu.service;

import com.wyu.dao.KCBDao;
import com.wyu.dao.KCBDaoImp1;
import com.wyu.pojo.KCB;

import java.util.List;

public class KCBServiceImp1 implements KCBService {
    private KCBDao dao = new KCBDaoImp1();
    @Override
    public List<KCB> selectByKCBpage(String page, String limit) {
        int count =   Integer.parseInt(limit);
        int start  = (Integer.parseInt(page)-1) * count;
        List<KCB> list =dao.selectBypage(start,count);
        return list;
    }

    @Override
    public int getCount() {
        return  dao.selectByCount();
    }

    @Override
    public List<KCB> selectKCBByXh(int xh,String page, String limit) {
        int count =   Integer.parseInt(limit);
        int start  = (Integer.parseInt(page)-1) * count;
        List<KCB> list =dao.selectBypageGRKC(xh,start,count);
        return list;
    }

    @Override
    public int getCountAndxh(int xh) {
        return  dao.selectByCountAndxh(xh);
    }

    @Override
    public int checkXSXK(int xh, String kch) {
        List<KCB> kc = dao.selectByXhAndKch(xh,kch);
        if (kc==null || kc.size()==0)
        {
            return 0;
        }
        return 1;
    }
}
