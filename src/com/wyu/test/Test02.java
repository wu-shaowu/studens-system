package com.wyu.test;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.Zyb;
import com.wyu.util.GetCt;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class Test02 {
    //1.添加数据
    @Test
    public void insert(){
        //创建一个操作数据库对象

        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            QueryRunner qr = new QueryRunner();
            /*System.out.println("1111111");*/
            ct = GetCt.getConnection();
            /*System.out.println("2222222");*/
            String sql = "insert into zyb(id,zym,rs,fdy)values(?,?,?,?)";
            Zyb zyb =new Zyb(11,"人工智能",130,"欧阳锋");//这里继续写8会和已有的冲突
            BeanHandler handler = new BeanHandler(Zyb.class);
            Object insert = qr.insert(ct, sql, handler,zyb.getId(),zyb.getZym(),zyb.getRs(),zyb.getFdy());
           System.out.println(insert);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
    }


    //2.修改数据
    @Test
    public void upadte(){
        //创建一个操作数据库对象
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "update zyb set rs=? where id=?";
            int i = qr.update(ct,sql,100,8);
            if(i>0){
                System.out.println("修改成功"+i+"条数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
    }

    //3.删除数据
    @Test
    public void delete(){
        //创建一个操作数据库对象
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "delete from zyb where id=?";
            int i = qr.update(ct,sql,8);
            if(i>0){
                System.out.println("删除成功"+i+"条数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
    }
    //4.查询数据-普通查询
    @Test
    public void select1(){
        //创建一个操作数据库对象
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select * from zyb where id=?";
            MapHandler handler = new MapHandler();
            Map<String ,Object> map=qr.query(ct,sql,handler,7);
            map.forEach((k,v)->System.out.println(k+","+v));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
    }
    //4.查询多条数据-普通查询
    @Test
    public void select2(){
        //创建一个操作数据库对象
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select * from zyb";
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> list = qr.query(ct, sql, handler);
            list.forEach(li->System.out.println(li));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
    }
    //5.查询单条数据-对象接收
    @Test
    public void select3(){
        //创建一个操作数据库对象
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select * from zyb where id = ?";
            BeanHandler<Zyb> handler = new BeanHandler(Zyb.class);
            Zyb zyb = qr.query(ct,sql,handler,1);
            System.out.println(zyb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
    }
    //6.查询多条数据-对象接收
    @Test
    public void select4(){
        //创建一个操作数据库对象
        QueryRunner qr = new QueryRunner();
        Connection ct = null;  //待会关闭资源
        //获得数据库连接，德鲁伊数据源
        try {
            ct = GetCt.getConnection();
            String sql = "select * from zyb ";
            BeanListHandler<Zyb> handler = new BeanListHandler(Zyb.class);
            List<Zyb> list = qr.query(ct, sql, handler);
            list.forEach(li->System.out.println(li));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(ct);
        }
    }
}
