package com.kkb.mapper;

import com.kkb.pojo.GameRecord;

/**
 *  比赛记录接口
 */
public interface GameRecordMapper {
    // 添加比赛记录
    int add(GameRecord record);
}
