package com.kkb.mapper;

import com.kkb.pojo.QueryTeamVO;
import com.kkb.pojo.QueryVO;
import com.kkb.pojo.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Mapper接口
 */
public interface TeamMapper {


    void delList(List<Integer> list);

    void addList(List<Team> list);

    int update1(Team team);

    List<Team> queryByVO(QueryTeamVO vo);

    Team queryById1(Integer teamId);

    Team queryById2(Integer teamId);

    List<Team> queryAll2();

    List<Map<String, Object>> getTwoColumnList();

    Map<String, Object> getTwoColumn(int teamId);

    int getCount();


    List<Team> queryByName(String teamName);

    List<Team> queryByLocation(String location);

    List<Team> queryByFiled(@Param("column") String column, @Param("columnValue") String value);


    List<Team> queryByCondition(QueryVO vo);

    List<Team> queryByRange3(Map<String, Object> map);

    List<Team> queryByRange2(@Param("min") Integer min, @Param("max") Integer max);

    List<Team> queryByRange1(Integer min, Integer max);


    //查询所有
    List<Team> queryAll();

    //根据id查询
    Team queryById(Integer teamId);

    //添加
    int add(Team team);

    //修改
    int update(Team team);

    //删除
    int del(Integer teamId);
}
