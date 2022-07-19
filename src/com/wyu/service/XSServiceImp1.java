package com.wyu.service;

import com.wyu.dao.XSDao;
import com.wyu.dao.XSDaoImp1;
import com.wyu.pojo.XS;

import java.util.List;

public class XSServiceImp1 implements XSService {
    private XSDao dao = new XSDaoImp1();
    @Override
    public XS login(String xh, String mm) {
        //用户登录，要先用学号去数据库查询，这个学生是否存在，如果存在则返回这个学生对象，如果不存在，则返回null
        //这些操作都要去查询数据库
        //调用dao层操作数据库

        XS xs =dao.selectByXh(xh);
        if (xs!=null){
            //说明查询到了这个员工
            //判断密码是否正确
            if (xs.getMm().equals(mm)){
                return xs;
            }
        }
        return null;
    }

    @Override
    public List<XS> selectXSAll(String page, String limit) {
        int count =   Integer.parseInt(limit);
        int start  = (Integer.parseInt(page)-1) * count;
        List<XS> list =dao.selectBypage(start,count);
        return list;
    }

    @Override
    public int getCount() {
        return dao.selectCount();

    }

    @Override
    public int deletebyXh(String xh) {
        return dao.deleteXsByXh(xh);
    }
}
