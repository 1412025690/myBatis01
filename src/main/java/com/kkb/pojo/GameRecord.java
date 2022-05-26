package com.kkb.pojo;

import java.util.Date;

// 比赛记录的实体类
public class GameRecord {
    private String recordId;
    private Integer homeTeamId;
    private Date gameTime;
    private Integer score;
    private Integer visitingTeamId;

    @Override
    public String toString() {
        return "GameRecord{" +
                "recordId='" + recordId + '\'' +
                ", homeTeamId=" + homeTeamId +
                ", gameTime=" + gameTime +
                ", score=" + score +
                ", visitingTeamId=" + visitingTeamId +
                '}';
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Date getGameTime() {
        return gameTime;
    }

    public void setGameTime(Date gameTime) {
        this.gameTime = gameTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getVisitingTeamId() {
        return visitingTeamId;
    }

    public void setVisitingTeamId(Integer visitingTeamId) {
        this.visitingTeamId = visitingTeamId;
    }
}
