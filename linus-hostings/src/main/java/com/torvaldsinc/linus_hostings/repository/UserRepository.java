package com.torvaldsinc.linus_hostings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torvaldsinc.linus_hostings.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}