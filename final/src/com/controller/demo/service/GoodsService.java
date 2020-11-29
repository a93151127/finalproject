package com.controller.demo.service;

import java.util.List;

import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Goods;

public interface GoodsService {

    List<Goods> queryAll();

    List<Goods> queryByStartEnd(int start, int end);

    Goods querDetail(String productCode);
    
    void register(Goods goods);

    void delete(String PK);
    
    void update(Goods goods);
    
    public Goods queryByProductCode(String productCode);
}