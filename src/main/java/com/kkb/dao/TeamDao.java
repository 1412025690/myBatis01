package com.kkb.dao;

import com.kkb.pojo.Team;

import java.util.List;

/**
 * 原有的Dao写法
 */
public interface TeamDao {
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
