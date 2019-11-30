package com.example.demo.mall.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class LocalDateTimeAndDate {

    private String id;
    private LocalDateTime onlintime;
    private Date createDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getOnlintime() {
        return onlintime;
    }

    public void setOnlintime(LocalDateTime onlintime) {
        this.onlintime = onlintime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @Override
    public String toString() {
        return "LocalDateTimeAndDate{" +
                "id='" + id + '\'' +
                ", onlintime=" + onlintime +
                ", createDate=" + createDate +
                '}';
    }
}
