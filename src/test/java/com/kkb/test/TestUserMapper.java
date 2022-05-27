package com.kkb.test;

import com.kkb.mapper.UsersMapper;
import com.kkb.pojo.Team;
import com.kkb.pojo.Users;
import com.kkb.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

/**
 *  测试类
 */
public class TestUserMapper {
    private UsersMapper mapper = MyBatisUtil.getSqlSession().getMapper(UsersMapper.class); //拿到代理对象
    @Test
    public void test01(){
        Users user = mapper.queryById(1);
        System.out.println(user);
    }

    @Test
    public void test02(){
        Users user = mapper.queryById2(1);
        System.out.println(user);
    }
}
