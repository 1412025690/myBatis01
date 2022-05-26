package com.kkb.test;

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
 *  测试类
 */
public class TestTeam {
    private String resource = "mybatis.xml";    //mybatis 画的图纸
    private SqlSession sqlSession = null;
    @Test
    public void testDelete(){
        int delete = sqlSession.delete("com.kkb.pojo.Team.del", 1115);
        sqlSession.commit();
        System.out.println("受影响行数:"+delete);
    }

    @Test
    public void testUpdate(){
        Team team = sqlSession.selectOne("com.kkb.pojo.Team.queryById",1115);
        team.setTeamName("邢帅帅的球队");
        team.setLocation("北京");
        int update = sqlSession.update("com.kkb.pojo.Team.update", team);
        sqlSession.commit();
        System.out.println("受影响行数="+update);
    }

    //添加
    @Test
    public void testAdd(){
        Team team = new Team();
        team.setTeamName("qz的球队");
        team.setLocation("郑州");
        team.setCreateTime(new Date());
        int insert = sqlSession.insert("com.kkb.pojo.Team.add",team);// 增删改 必须手动提交事务!!!否则不生效
        sqlSession.commit();    //  手动提交事务
        System.out.println("受影响行数="+insert);
    }


    //根据id查询
    @Test
    public void test02(){
        System.out.println("test02-------");
        Team team = sqlSession.selectOne("com.kkb.pojo.Team.queryById", 1001);
        System.out.println(team);
    }

    @Before //表示该方法在执行测试方法之前先执行
    public void before(){
        //System.out.println("before-------");
        // 读取配置文件
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);//根据图纸创建工厂
        // 获取连接
        sqlSession = factory.openSession();
    }
    @After  //表示该方法执行在测试方法之后执行
    public void after(){
        //System.out.println("after--------");
        sqlSession.close();
    }

    //  查询所有
    @Test
    public void test01(){
        SqlSession sqlSession = null;
        try {
            // 读取配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            // 创建工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);//根据图纸创建工厂
            // 获取连接
            sqlSession = factory.openSession();
            // 执行sql语句
            List<Team> list = sqlSession.selectList("com.kkb.pojo.Team.queryAll");
            // 遍历结果
            for (Team team:list) {
                System.out.println(team);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            // 关闭资源
            sqlSession.close();
        }
    }
}
