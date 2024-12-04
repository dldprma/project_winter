package com.gz.app.schedule.vo;

import lombok.Data;

@Data
public class EventVo {
    private String id;
    private String title;
    private String start;
    private String end;
    private String priority;
}
