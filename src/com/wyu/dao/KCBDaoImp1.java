package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.KCB;
import com.wyu.util.GetCt;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class KCBDaoImp1 implements KCBDao {
    @Override
    public List<KCB> selectByXhAndKch(int xh, String kch) {
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select k.* from kcb k ,xskcb x where k.kch=x.kch and  x.xh=? and k.kch=?;";
            BeanListHandler<KCB> handler = new BeanListHandler(KCB.class);
            List<KCB> list = qr.query(ct, sql, handler,xh,xh,kch);

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
    public List<KCB> selectBypage(int start, int count) {
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select  * from kcb limit ?,?;";
            BeanListHandler<KCB> handler = new BeanListHandler(KCB.class);
            List<KCB> list = qr.query(ct, sql, handler,start,count);

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
    public int selectByCount() {
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        try {
            ct = GetCt.getConnection();
            String sql = "select count(*) count from kcb;";
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
    public List<KCB> selectBypageGRKC(int xh, int start, int count) {
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select k.* from kcb k ,xskcb x where k.kch=x.kch and  x.xh=? limit ?,?;";
            BeanListHandler<KCB> handler = new BeanListHandler(KCB.class);
            List<KCB> list = qr.query(ct, sql, handler,xh,start,count);

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
    public int selectByCountAndxh(int xh) {
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        try {
            ct = GetCt.getConnection();
            String sql = "select count(*) count from kcb k,xskcb x where  k.kch=x.kch and x.xh=?";
            return ((Long)qr.query(ct,sql,new ScalarHandler<>(),xh)).intValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }
}
