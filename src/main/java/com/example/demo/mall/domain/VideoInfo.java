package com.example.demo.mall.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class VideoInfo implements Serializable {
    private String id;

    private String categoryId;

    private String name;

    private String des;

    private String coverOssId;

    private String videoOssId;

    private Integer status;

    private Date onlineTime;

    private Date offlineTime;

    private String createBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String reserve;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCoverOssId() {
        return coverOssId;
    }

    public void setCoverOssId(String coverOssId) {
        this.coverOssId = coverOssId;
    }

    public String getVideoOssId() {
        return videoOssId;
    }

    public void setVideoOssId(String videoOssId) {
        this.videoOssId = videoOssId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Date getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", name=").append(name);
        sb.append(", des=").append(des);
        sb.append(", coverOssId=").append(coverOssId);
        sb.append(", videoOssId=").append(videoOssId);
        sb.append(", status=").append(status);
        sb.append(", onlineTime=").append(onlineTime);
        sb.append(", offlineTime=").append(offlineTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", reserve=").append(reserve);
        sb.append("]");
        return sb.toString();
    }
}