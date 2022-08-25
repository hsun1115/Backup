package com.example.Backup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Backup.entities.winners.Winner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WinnerDao extends BaseMapper<Winner> {
}
