package com.to8to.o2o.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {

    private static SqlSession sqlSession;

    /**
     * 获取数据库连接态
     * @return sqlSession
     */

    public static SqlSession getSqlSession() {

        try {
            Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSession;
    }
}
