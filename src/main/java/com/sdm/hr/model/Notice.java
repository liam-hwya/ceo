package com.sdm.hr.model;

import com.sdm.core.model.DefaultEntity;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "notice")
@Table(name = "tbl_hr_notices")
public class Notice extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "description" , nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "noticeDate" , nullable = false)
    private Date noticeDate;

    @Column(name = "managerId")
    @Nullable
    private Long managerId;

    @ElementCollection
    @CollectionTable(name = "tbl_hr_notice_attachments", joinColumns = @JoinColumn(name = "noticeId"))
    @Column( nullable = false)
    private List<String> fileId;


    public List<String> getFileId() {
        return fileId;
    }

    public void setFileId(List<String> fileId) {
        this.fileId = fileId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    @Nullable
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(@Nullable Long managerId) {
        this.managerId = managerId;
    }
}
