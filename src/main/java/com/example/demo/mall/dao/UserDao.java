package com.example.demo.mall.dao;

import com.example.demo.mall.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
