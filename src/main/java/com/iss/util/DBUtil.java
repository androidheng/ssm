package com.iss.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

//使用maybaatis
public class DBUtil {

    private static SqlSessionFactory sessionFactory;//一个会话工厂
    //静态块保证先加载
    static {
        Reader reader;
        try{
            //先加载配置文件
            reader= Resources.getResourceAsReader("mybatis-config.xml");
            sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.err.println("");
        }
    }

    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }
}
