package com.example.Backup.controller;

import com.example.Backup.service.bid.BidService;
import com.example.Backup.entities.bids.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BidController {
    @Autowired
    BidService bidService;

    @PostMapping("intuit/bid/addbid")
    public void insertBid(@RequestBody Bid bid) {
        bidService.addBid(bid);
    }
}
