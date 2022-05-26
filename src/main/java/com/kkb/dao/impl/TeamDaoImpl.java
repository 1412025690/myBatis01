package com.kkb.dao.impl;

import com.kkb.dao.TeamDao;
import com.kkb.pojo.Team;
import com.kkb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeamDaoImpl implements TeamDao {
    /**
     * 查询所有球队
     * @return
     */
    @Override
    public List<Team> queryAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        return sqlSession.selectList("com.kkb.pojo.Team.queryAll");
    }

    /**
     *  根据id查询球队
     * @param teamId
     * @return
     */
    @Override
    public Team queryById(Integer teamId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        return sqlSession.selectOne("com.kkb.pojo.Team.queryById", teamId);
    }

    /**
     * 添加球队
     * @param team
     * @return
     */
    @Override
    public int add(Team team) {
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        int num= sqlSession.insert("com.kkb.pojo.Team.add",team);
        sqlSession.commit();
        return num;
    }
    /**
     * 更新球队
     * @param team
     * @return
     */
    @Override
    public int update(Team team) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        sqlSession.commit();
        return sqlSession.update("com.kkb.pojo.Team.update", team);
    }
    /**
     * 根据id删除球队
     * @param teamId
     * @return
     */
    @Override
    public int del(Integer teamId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        return sqlSession.delete("com.kkb.pojo.Team.del", teamId);
    }
}
