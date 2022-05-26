package com.kkb.test;

import com.kkb.mapper.TeamMapper;
import com.kkb.pojo.Team;
import com.kkb.util.MyBatisUtil;
import org.junit.Test;

import java.util.Date;

/**
 * 测试类
 */
public class TestTeamMapper {
    private TeamMapper teamMapper = MyBatisUtil.getSqlSession().getMapper(TeamMapper.class);    //通过动态代理的方式产生实现类

    @Test
    public void testAdd(){
        Team team = new Team();
        team.setLocation("杭州");
        team.setTeamName("开课吧");
        team.setCreateTime(new Date());
        int add = teamMapper.add(team);
        MyBatisUtil.getSqlSession().commit();
        System.out.println("受影响行数"+add);
        System.out.println("新增的球队:"+team.getTeamId());
    }

    @Test
    public void testQueryById(){
        teamMapper.queryById(1001);
    }
    @Test
    public void testDel(){
        teamMapper.del(1053);
        MyBatisUtil.getSqlSession().commit();
    }

}
