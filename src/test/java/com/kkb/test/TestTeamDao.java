package com.kkb.test;

import com.kkb.dao.TeamDao;
import com.kkb.dao.impl.TeamDaoImpl;
import com.kkb.pojo.Team;
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
 * 测试类
 */
public class TestTeamDao {
    private TeamDao teamDao = new TeamDaoImpl();

    @Test
    public void testDel() {
        int delete = teamDao.del(1021);
        System.out.println("受影响行数:" + delete);
    }

    @Test
    public void testUpdate() {
        Team team = teamDao.queryById(1053);
        team.setTeamName("邢帅帅的球队");
        team.setLocation("北京");
        int update = teamDao.update(team);
        System.out.println("受影响行数=" + update);
    }

    //添加
    @Test
    public void testAdd() {
        Team team = new Team();
        team.setTeamName("qz的球队");
        team.setLocation("郑州");
        team.setCreateTime(new Date());
        int insert = teamDao.add(team);
        System.out.println("受影响行数=" + insert);
    }


    //根据id查询
    @Test
    public void test02() {
        Team team = teamDao.queryById(1001);
        System.out.println(team);
    }
    //查询所有
    @Test
    public void test01() {
        List<Team> teams = teamDao.queryAll();
        teams.forEach(team -> System.out.println(team));

    }
}
