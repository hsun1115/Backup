package com.example.Backup.service.Impl;

import com.example.Backup.entities.bids.Bid;

import java.util.Comparator;

public class BidComparator implements Comparator<Bid> {

    @Override
    public int compare(Bid o1, Bid o2) {
        if (o1.getBid_time().compareTo(o2.getBid_time()) == 0) {
            if (o1.getPrice() > o2.getPrice())
                return 1;
            else if (o1.getPrice() < o2.getPrice())
                return -1;
            return 0;
        } else if (o1.getBid_time().after(o2.getBid_time())) {
            return 1;
        } else if (o1.getBid_time().before(o2.getBid_time())) {
            return -1;
        }
        return 0;
    }
}
