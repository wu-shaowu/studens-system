package com.wyu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class GetCt {
    @Test
    public static Connection getConnection() throws Exception {
        //创建一个Properties类，用来读取配置文件
     /*   System.out.println("bbbbbbbbb");*/
        Properties per = new Properties();//porperties是一个Map集合的自己和，存储方式也是key:value，它是唯一一个可以持久化的集合
        //得到配置文件的输入流
       /* InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");*/
        //很明显，上面一句老师的这个在测试的时候没问题但是使用的时候却出现了获取不到的问题
        InputStream is = GetCt.class.getClassLoader().getResourceAsStream("druid.properties");
        //将流装载到配置文件类中
  /*      System.out.println("afaajj");*/
        //这里往下不行
        per.load(is);
        //获取DataSource数据资源对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(per);
        //获得数据库连接
    /*System.out.println("wtthh");*/

        Connection connection = dataSource.getConnection();
/*  System.out.println("wtfffffffffffff");*/

        return connection;
    }
}
/*
public class GetCt {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties pro = new Properties();
        InputStream is = GetCt.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //5.获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
*/
