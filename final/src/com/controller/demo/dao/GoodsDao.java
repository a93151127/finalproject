package com.controller.demo.dao;

import java.util.List;

import com.controller.demo.domain.Goods;

public interface GoodsDao {
	Goods findByPk(String pk);

    List<Goods> findAll();

    List<Goods> findStartEnd(int start, int end);

    void create(Goods goods);

    void modify(Goods goods);

    void remove(String pk);
}
