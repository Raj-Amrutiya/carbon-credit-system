package com.ccms.controller;

import com.ccms.model.Wallet;
import com.ccms.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Wallet> getByUser(@PathVariable Long userId) {
        return walletService.findByUserId(userId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/credit")
    public ResponseEntity<Wallet> credit(@RequestBody BalanceRequest request) {
        return ResponseEntity.ok(walletService.credit(request.userId(), request.amount()));
    }

    @PostMapping("/debit")
    public ResponseEntity<?> debit(@RequestBody BalanceRequest request) {
        try {
            return ResponseEntity.ok(walletService.debit(request.userId(), request.amount()));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public record BalanceRequest(Long userId, Double amount) {}
}
