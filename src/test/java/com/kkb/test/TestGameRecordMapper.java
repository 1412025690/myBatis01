package com.kkb.test;

import com.kkb.mapper.GameRecordMapper;
import com.kkb.pojo.GameRecord;
import com.kkb.util.MyBatisUtil;
import org.junit.Test;

import java.util.Date;

/**
 * 测试类
 */
public class TestGameRecordMapper {
    @Test
    public void testAdd(){
        GameRecordMapper mapper = MyBatisUtil.getSqlSession().getMapper(GameRecordMapper.class);
        GameRecord record = new GameRecord();
        record.setHomeTeamId(1003);
        record.setVisitingTeamId(1001);
        record.setScore(90);
        int add = mapper.add(record);
        MyBatisUtil.getSqlSession().commit();
        System.out.println("受影响行数"+add);
    }
}
