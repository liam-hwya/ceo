package com.sdm.pm.entity;

import java.util.Date;

import javax.persistence.*;
import com.sdm.core.model.DefaultEntity;

@Entity(name = "TaskEntity")
@Table(name = "tbl_pm_tasks")
public class TaskEntity extends DefaultEntity{

    private static final long serialVersionUID = 739168064520778219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private long projectId;

    @Column(nullable = false)
    private long fromId;

    @Column(nullable = false)
    private long toId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromTime;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toTime;

    @Column(nullable = false)
    private String description;

    @Column
    private float currentPercentage;

    @Column
    private int level;

    @Column
    private int priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getFromId() {
        return fromId;
    }

    public void setFromId(long fromId) {
        this.fromId = fromId;
    }

    public long getToId() {
        return toId;
    }

    public void setToId(long toId) {
        this.toId = toId;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCurrentPercentage() {
        return currentPercentage;
    }

    public void setCurrentPercentage(float currentPercentage) {
        this.currentPercentage = currentPercentage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        Assigned,
        Processing,
        Finished,
        Checking,
        Completed,
        Failed
    }
}