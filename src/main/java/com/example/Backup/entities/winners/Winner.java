package com.example.Backup.entities.winners;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Winner {
    private Long job_id;
    private Long poster_id;
    private Long buyer_id;
    private Long price;
    private String status;
}
