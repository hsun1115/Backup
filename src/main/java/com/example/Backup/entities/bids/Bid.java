package com.example.Backup.entities.bids;
import lombok.*;

import java.sql.Timestamp;

@Data
public class Bid {
    Long job_id;
    Long buyer_id;
    Long price;
    Timestamp bid_time;
    Boolean is_win;
}
