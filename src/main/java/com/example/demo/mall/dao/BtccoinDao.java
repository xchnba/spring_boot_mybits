package com.example.demo.mall.dao;

import com.example.demo.mall.domain.Btccoin;
import com.example.demo.mall.domain.Shares;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BtccoinDao extends JpaRepository<Btccoin,Integer> {
}
