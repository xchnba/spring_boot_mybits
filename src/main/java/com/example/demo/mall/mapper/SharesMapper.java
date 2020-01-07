package com.example.demo.mall.mapper;


import com.example.demo.mall.domain.Shares;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SharesMapper {
    // 2007-10-14,2008-11-04
    @Select("SELECT * FROM shares t WHERE t.gpdate >'2007-10-14' AND t.gpdate <'2019-12-31' ORDER BY gpdate asc")
    List<Shares> getSharesBydate();
}
