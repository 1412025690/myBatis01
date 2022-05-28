package com.kkb.test;

import com.kkb.util.MyBatisUtil;
import org.junit.Test;
import org.xzk.mapper.TeamMapper;
import org.xzk.pojo.Team;
import org.xzk.pojo.TeamExample;

import java.util.List;

/**
 * 测试反向生成的内容
 */
public class TestGenerator {
    private TeamMapper mapper = MyBatisUtil.getSqlSession().getMapper(TeamMapper.class);

    @Test
    public void test1(){
        Team team = mapper.selectByPrimaryKey(1001);
        System.out.println(team);
    }

    @Test
    public void test2(){
        Team team = new Team();
        team.setTeamName("xqz-test");
        int i = mapper.insertSelective(team);
        MyBatisUtil.getSqlSession().commit();
        System.out.println(team);
    }
    @Test
    public void test3(){
        TeamExample example = new TeamExample();        //可以理解为 为多条件查询、排序等服务的类
        TeamExample.Criteria criteria = example.createCriteria();   //存放条件的容器
        //向容器中 添加条件
        criteria.andTeamNameLike("%人%");
        criteria.andTeamIdBetween(1001,1100);
        //排序内容
        example.setOrderByClause("teamName");
        List<Team> teams = mapper.selectByExample(example); //多条件查询
        for (Team team : teams) {
            System.out.println(team);
        }
    }
}
