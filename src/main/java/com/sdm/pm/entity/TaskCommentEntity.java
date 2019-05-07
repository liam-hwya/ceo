package com.sdm.pm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sdm.core.model.DefaultEntity;

@Entity(name = "TaskCommentEntity")
@Table(name = "tbl_pm_task_comments")
public class TaskCommentEntity extends DefaultEntity{

    private static final long serialVersionUID = 739168064520778219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private long taskId;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private long userId;

    @Column
    private String attachment;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}