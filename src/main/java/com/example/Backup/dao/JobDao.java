package com.example.Backup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Backup.entities.jobs.Job;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobDao extends BaseMapper<Job> {
}
