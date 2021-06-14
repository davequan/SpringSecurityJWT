package com.quan.quan.repository;

import com.quan.quan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository  extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
