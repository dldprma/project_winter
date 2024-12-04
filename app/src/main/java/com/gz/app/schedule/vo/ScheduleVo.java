package com.gz.app.schedule.vo;

import lombok.Data;

@Data
public class ScheduleVo {
    private String no;
    private String writerNo;
    private String memoNo;
    private String businessNo;
    private String busihisNo;
    private String storeNo;
    private String priority;
    private String priorityName;
    private String title;
    private String content;
    private String location;
    private String start;
    private String startDate;
    private String startTime;
    private String end;
    private String finishDate;
    private String finishTime;
    private String allDay;
    private String almTime;
    private String shareYn;
    private String delYn;
}
