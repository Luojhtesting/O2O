package com.to8to.o2o.testScripts;

import com.to8to.o2o.util.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;

public class TestDatabase {
    public static void main(String[] args) {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        int i = sqlSession.selectOne("getCountGoods");
        System.out.println(i);

    }
}
