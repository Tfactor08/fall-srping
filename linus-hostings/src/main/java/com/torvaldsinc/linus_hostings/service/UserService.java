package com.torvaldsinc.linus_hostings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.torvaldsinc.linus_hostings.model.User;
import com.torvaldsinc.linus_hostings.repository.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserService {
    UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Transactional
    public User create(User user) {
        return userRepo.save(user);
    }
}
