package com.example.Backup.entities.jobs;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Job {
    private Long job_id;
    private Long poster_id;
    private String job_info;
    private String status;
}
