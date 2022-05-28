package com.kkb.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.mapper.TeamMapper;
import com.kkb.pojo.QueryTeamVO;
import com.kkb.pojo.Team;
import com.kkb.util.MyBatisUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestSQL {
    private TeamMapper teamMapper = MyBatisUtil.getSqlSession().getMapper(TeamMapper.class);

    @Test
    public void test1() {
        QueryTeamVO vo = new QueryTeamVO();
        vo.setName("人");
        vo.setEndTime(new Date());
        vo.setLocation("加利福尼亚州洛杉矶");
        List<Team> teams = teamMapper.queryByVO(vo);
        for (Team team : teams) {
            System.out.println(team);
        }
    }

    @Test
    public void test2() {
        Team team = new Team();
        team.setTeamId(1032);
        team.setTeamName("秋刀鱼不过期");
        team.setLocation("郑州");
        int update = teamMapper.update1(team);
        MyBatisUtil.getSqlSession().commit();
        System.out.println(update);
    }

    @Test
    public void test3() {
        List<Team> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Team team = new Team();
            team.setTeamName("秋刀鱼" + i);
            team.setLocation("郑州" + i);
            list.add(team);
        }
        teamMapper.addList(list);
        MyBatisUtil.getSqlSession().commit();
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        list.add(1130);
        list.add(1131);
        list.add(1132);
        teamMapper.delList(list);
        MyBatisUtil.getSqlSession().commit();
    }

    @Test
    public void test5() {
        //PageHelper必须紧挨着要查询语句 必须在查询语句上面,而且 只对第一条查询语句生效
        PageHelper.startPage(2,5);
        List<Team> teams = teamMapper.queryAll();       //查询语句结尾不能有分号
        teams.forEach(team -> System.out.println(team));
        PageInfo<Team> info = new PageInfo<>();
        System.out.println("分页的信息如下:");
        System.out.println("当前页:"+info.getPageNum());
        System.out.println("总页数:"+info.getPages());
        System.out.println("前一页:"+info.getPrePage());
        System.out.println("所有导航页号:"+info.getNavigatepageNums());
    }
}