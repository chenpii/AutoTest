package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 数据库工具类
 *
 * @author chenpi
 * @create 2022-04-10 12:33
 */
public class DatabaseUtil {

    public static SqlSession getSqlSession() throws IOException {
        //获取数据库配置文件
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");

        //加载配置文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //sqlSession就是能够执行配置文件中的sql语句
        SqlSession sqlSession = factory.openSession();

        return sqlSession;
    }
}
