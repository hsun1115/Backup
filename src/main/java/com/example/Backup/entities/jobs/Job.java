package com.example.Backup.entities.jobs;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "JOB")
public class Job {
    @Id
    @TableId
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ddl;

    @Column(columnDefinition="TEXT")
    private String job_info;

    @Column(nullable = false)
    private Long poster_id;

    private String status;
}
