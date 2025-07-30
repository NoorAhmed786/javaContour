package com.noor.the_noor_residency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.noor.the_noor_residency.entity.Role;
import com.noor.the_noor_residency.entity.User;
import com.noor.the_noor_residency.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {

        // **1) Username unique check**
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        // **2) Password must not be empty**
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        // **3) Encode password only once**
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // **4) Default role**
        if (user.getRole() == null) {
            user.setRole(Role.CUSTOMER);
        }

        // **5) Default account balance**
        user.setAccountBalance(5000.0);

        // **6) Save user**
        userRepo.save(user);

        System.out.println("✅ User saved successfully: " + user.getUsername() + " | Role: " + user.getRole());
    }

    /**
     * **Admin User Automatically Create** if not exist
     */
    @Bean
    public CommandLineRunner createAdminUser(UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            if (userRepo.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123")); // encode only once
                admin.setRole(Role.ADMIN);
                admin.setAccountBalance(10000.0);
                userRepo.save(admin);
                System.out.println("✅ Default Admin user created: admin / admin123");
            }
        };
    }
}
