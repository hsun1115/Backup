package com.example.Backup.service.bid;

import com.example.Backup.entities.bids.Bid;
import com.example.Backup.entities.winners.Winner;

import java.util.List;

public interface BidService {
    int addBid(Bid bid);
    Bid updateBidById(Long id, Bid bid);
    void deleteBidById(Long id);
    List<Bid> getAllBidByJobId(Long id);
    Winner findWinnerByJobId(Long id);
}
