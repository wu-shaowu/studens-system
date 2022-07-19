package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.XS;
import com.wyu.util.GetCt;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class XSDaoImp1 implements XSDao {
    @Override
    public XS selectByXh(String xh) {
        //查询数据库：JdbcUtil工具类去查询
        //创建一个操作数据库对象
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        XS xs = null;
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select x.xh,x.xm,x.mm,x.xb,x.cssj,z.zym,x.zxf,x.bz,x.zp from xsb x,zyb z where x.zy_id=z.id and  x.xh=?";
            BeanHandler<XS> handler = new BeanHandler(XS.class);
            xs = qr.query(ct,sql,handler,xh);
            System.out.println(xs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
        return  xs;
    }

    @Override
    public List<XS> selectBypage(int start, int count) {
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select x.xh,x.xm,x.mm,x.xb,x.cssj,z.zym,x.zxf,x.bz,x.zp from xsb x,zyb z where x.zy_id=z.id and x.bz!=1 limit ?,?";
            BeanListHandler<XS> handler = new BeanListHandler(XS.class);
            List<XS> list = qr.query(ct, sql, handler,start,count);

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
        return null;
    }

    @Override
    public int selectCount() {
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        try {
            ct = GetCt.getConnection();
            String sql = "select count(*) count from xsb where bz !=1";
            return ((Long)qr.query(ct,sql,new ScalarHandler<>())).intValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }

    @Override
    public int deleteXsByXh(String xh) {
        //创建一个操作数据库对象
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "delete from xsb where xh=?";
            int i = qr.update(ct,sql,xh);
            if(i>0){
                System.out.println("删除成功"+i+"条数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }
}
