package com.example.Backup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Backup.entities.bids.Bid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BidDao extends BaseMapper<Bid> {
}
