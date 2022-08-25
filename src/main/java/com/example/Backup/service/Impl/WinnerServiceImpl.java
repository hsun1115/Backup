package com.example.Backup.service.Impl;

import com.example.Backup.dao.WinnerDao;
import com.example.Backup.entities.winners.Winner;
import com.example.Backup.service.winner.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WinnerServiceImpl implements WinnerService {
    @Autowired
    WinnerDao winnerDao;
    @Override
    public void addWinner(Winner winner) {
        winnerDao.insert(winner);
    }

    @Override
    public Winner updateWinnerByJobId(Long id) {
        //to do update job status for the future
        return null;
    }
}
