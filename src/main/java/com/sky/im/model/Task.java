package com.sky.im.model;

import java.util.Date;

public class Task {
    private Long id;

    private String taskName;

    private String content;

    private Date beginTimePlan;

    private Date endTimePlan;

    private Date beginTimeActual;

    private Date endTimeActual;

    private Integer status;

    private Long progress;

    private String remark;

    private Date createTime;

    private Long createBy;

    private Date updateTime;

    private Long updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getBeginTimePlan() {
        return beginTimePlan;
    }

    public void setBeginTimePlan(Date beginTimePlan) {
        this.beginTimePlan = beginTimePlan;
    }

    public Date getEndTimePlan() {
        return endTimePlan;
    }

    public void setEndTimePlan(Date endTimePlan) {
        this.endTimePlan = endTimePlan;
    }

    public Date getBeginTimeActual() {
        return beginTimeActual;
    }

    public void setBeginTimeActual(Date beginTimeActual) {
        this.beginTimeActual = beginTimeActual;
    }

    public Date getEndTimeActual() {
        return endTimeActual;
    }

    public void setEndTimeActual(Date endTimeActual) {
        this.endTimeActual = endTimeActual;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}