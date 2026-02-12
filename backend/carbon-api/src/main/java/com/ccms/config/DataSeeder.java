package com.ccms.config;

import com.ccms.model.Order;
import com.ccms.model.Project;
import com.ccms.model.User;
import com.ccms.model.Wallet;
import com.ccms.repository.OrderRepo;
import com.ccms.repository.ProjectRepo;
import com.ccms.repository.UserRepo;
import com.ccms.repository.WalletRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData(UserRepo userRepo, WalletRepo walletRepo, ProjectRepo projectRepo, OrderRepo orderRepo) {
        return args -> {
            if (!userRepo.findAllByEmail("admin@ccms.local").isEmpty()) {
                return;
            }

            User admin = new User("Admin", "admin@ccms.local", "admin123", "ADMIN");
            admin = userRepo.save(admin);

            Wallet wallet = new Wallet(admin.getId(), 1000.0);
            walletRepo.save(wallet);

            projectRepo.save(new Project("Solar Farm", "Renewable", 120.5, admin.getId()));
            projectRepo.save(new Project("Reforestation", "Nature", 300.0, admin.getId()));

            orderRepo.save(new Order(admin.getId(), 50.0, "BUY"));
        };
    }
}
