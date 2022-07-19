package com.wyu.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

//import org.junit.jupiter.api.Test;


//Druid测试类
public class Test01 {
    @Test
    public void getConnection() throws Exception {
        //创建一个Properties类，用来读取配置文件
        Properties per = new Properties();//porperties是一个Map集合的自己和，存储方式也是key:value，它是唯一一个可以持久化的集合
        //得到配置文件的输入流
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        //将流装载到配置文件类中
        per.load(is);
        //获取DataSource数据资源对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(per);
        //获得数据库连接
        Connection connection = dataSource.getConnection();
        //输出结果
        System.out.println(connection);
    }

}

