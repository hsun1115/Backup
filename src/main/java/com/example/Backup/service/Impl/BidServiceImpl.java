package com.example.Backup.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.Backup.dao.BidDao;
import com.example.Backup.dao.JobDao;
import com.example.Backup.dao.WinnerDao;
import com.example.Backup.entities.bids.Bid;
import com.example.Backup.entities.jobs.Job;
import com.example.Backup.entities.winners.Winner;
import com.example.Backup.exceptions.EntityNotFoundException;
import com.example.Backup.service.bid.BidService;
import com.example.Backup.util.JobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidDao bidDao;
    @Autowired
    private WinnerDao winnerDao;
    //@Autowired
   // private JobServiceImpl jobService;

    @Override
    public int addBid(Bid bid) {
        bidDao.insert(bid);
        Long jobId = bid.getJob_id();
        //jobService.updateJobStatus(jobId, JobStatus.BIDING);
        return 200;
    }

    @Override
    public Bid updateBidById(Long id, Bid bid) {
        if (null == id) {
            throw new NullPointerException();
        } else {
            UpdateWrapper<Bid> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("job_id", id);
            Bid newB = new Bid();
            newB.setBidder_id(bid.getBidder_id());
            newB.setBid_time(bid.getBid_time());
            newB.setIs_win(bid.getIs_win());
            newB.setPrice(bid.getPrice());
            bidDao.update(newB,updateWrapper);
        }
        return bid;
    }

    @Override
    public void deleteBidById(Long id) {
        bidDao.deleteById(id);
    }

    @Override
    public List<Bid> getAllBidByJobId(Long id) {
        List<Bid> list;
        if (null == id) {
            throw new NullPointerException();
        } else {
            QueryWrapper<Bid> qw = new QueryWrapper<>();
            qw.eq("job_id", id);
            qw.orderByAsc("bid_time");
            list = bidDao.selectList(qw);
            //return list;
        }
        return list;
    }

    @Override
    public Winner findWinnerByJobId(Long id) {
        if (null == id) {
            throw new NullPointerException();
        }
        List<Bid> list = getAllBidByJobId(id);
        List<Bid> minlist = new ArrayList<>();
        Bid res = null;
        Long min = Long.MAX_VALUE;
        for (Bid b : list) {
            min = Math.min(min, b.getPrice());
        }
        for (Bid b : list) {
            if (b.getPrice() == min) {
                minlist.add(b);
            }
        }
        if (minlist.size() == 1) {
            res = minlist.get(0);
        } else if (minlist.size() >= 2) {
            Timestamp  temp = minlist.get(0).getBid_time();
            for (int i = 1; i < minlist.size(); i++) {
                if (temp.after(minlist.get(i).getBid_time())) {
                    temp = minlist.get(i).getBid_time();
                }
            }
            for (Bid b : minlist) {
                if (b.getBid_time().equals(b.getBid_time())) {
                    res = b;
                }
            }
        }
        
        res.setIs_win(true);
        updateBidById(id, res);

//        Job j = jobService.getById(id);
//        jobService.updateJobStatus(id, JobStatus.ASSIGNED);
        Winner winner = new Winner();
        winner.setJob_id(res.getJob_id());
        winner.setBuyer_id(res.getBidder_id());
        winner.setPrice(res.getPrice());
        winner.setStatus(JobStatus.ASSIGNED);
        //winner.setPoster_id(j.getPoster_id());
        WinnerServiceImpl imp = new WinnerServiceImpl();
        imp.addWinner(winner);
        return winner;
    }
}
