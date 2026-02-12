package com.ccms.service;

import com.ccms.model.Wallet;
import com.ccms.repository.WalletRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {
    private final WalletRepo walletRepo;

    public WalletService(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }

    public Optional<Wallet> findByUserId(Long userId) {
        return walletRepo.findByUserId(userId);
    }

    public Wallet save(Wallet wallet) {
        return walletRepo.save(wallet);
    }

    public Wallet credit(Long userId, Double amount) {
        Wallet wallet = walletRepo.findByUserId(userId)
                .orElseGet(() -> new Wallet(userId, 0.0));
        wallet.setBalance(wallet.getBalance() + amount);
        return walletRepo.save(wallet);
    }

    public Wallet debit(Long userId, Double amount) {
        Wallet wallet = walletRepo.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
        if (wallet.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        wallet.setBalance(wallet.getBalance() - amount);
        return walletRepo.save(wallet);
    }
}
