package com.example.demo.mall.service.impl;


import com.example.demo.mall.domain.Shares;
import com.example.demo.mall.mapper.SharesMapper;
import com.example.demo.mall.service.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SharesServiceImpl implements SharesService {
    @Autowired
    SharesMapper sharesMapper;


    @Override
    public List<Shares> getSharesBydate() {
        return sharesMapper.getSharesBydate();
    }
}

