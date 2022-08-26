package com.example.Backup.entities.bids;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "BID")
public class Bid {
    @Id
    @Column(name = "bidder_id", nullable = false)
    Long bidder_id;

    @Column(name = "bid_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp bid_time;

    @Column(name = "is_win")
    Boolean is_win;

    @TableId
    @Column(name = "job_id", nullable = false)
    Long job_id;

    @Column(name = "price")
    Long price;

}
