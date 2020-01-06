package com.example.demo.mall.dao;

import com.example.demo.mall.domain.Shares;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SharesDao extends JpaRepository<Shares,Integer> {
}
