package com.kkb.test;

import com.kkb.mapper.TeamMapper;
import com.kkb.pojo.QueryVO;
import com.kkb.pojo.Team;
import com.kkb.util.MyBatisUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//测试输入映射 : 多个参数
public class TestTeamMapperArg {
    private TeamMapper teamMapper = MyBatisUtil.getSqlSession().getMapper(TeamMapper.class);

    @Test
    public void test01(){
        List<Team> teams = teamMapper.queryByRange1(1004, 1010);
        teams.forEach(team -> System.out.println(team));
    }

    @Test
    public void test02(){
        List<Team> teams = teamMapper.queryByRange2(1005, 1011);
        teams.forEach(team -> System.out.println(team));
    }

    @Test
    public void test03(){
        Map<String, Object> map = new HashMap<>();
        map.put("min",1010);
        map.put("max",1015);
        List<Team> teams = teamMapper.queryByRange3(map);
        teams.forEach(team -> System.out.println(team));
    }

    @Test
    public void test04(){
        QueryVO vo = new QueryVO();
        vo.setLocation("中国");
        vo.setName("%球队%");
        vo.setMin(1001);
        vo.setMax(1130);
        List<Team> teams = teamMapper.queryByCondition(vo);
        teams.forEach(team -> System.out.println(team));
    }

    @Test
    public void test05(){
        System.out.println("根据球队名称进行查询");
        List<Team> teams = teamMapper.queryByName("球队");
        teams.forEach(team -> System.out.println(team));
        System.out.println("根据球队位置查询");
        List<Team> teams2 = teamMapper.queryByLocation("中国");
        teams.forEach(team -> System.out.println(teams2));
    }
    @Test
    public void test06(){
        System.out.println("根据球队名称进行查询");
        List<Team> teams = teamMapper.queryByFiled("teamName","球队");
        teams.forEach(team -> System.out.println(team));
        System.out.println("根据球队位置查询");
        List<Team> teams2 = teamMapper.queryByFiled("location","中国");
        teams.forEach(team -> System.out.println(teams2));
    }

    @Test
    public void test07(){
        int count = teamMapper.getCount();
        System.out.println("总共的行数="+count);
    }

    @Test
    public void test08(){
        System.out.println(teamMapper.getTwoColumn(1001));
    }
    @Test
    public void test09(){
        List<Map<String, Object>> list = teamMapper.getTwoColumnList();
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }
    @Test
    public void test10(){
        List<Team> teams = teamMapper.queryAll2();
        teams.forEach(team -> System.out.println(team));
    }
}
