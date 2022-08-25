package com.example.Backup.service.winner;

import com.example.Backup.entities.winners.Winner;

public interface WinnerService {
    void addWinner(Winner winner);
    Winner updateWinnerByJobId(Long id);
}
