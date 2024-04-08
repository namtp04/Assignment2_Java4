package com.example.assignment.service;

import com.example.assignment.entity.Favorite;

import java.util.List;

public interface FavoriteInf {
    List<Favorite> findAll(String us);
    Favorite findByVideoId(String vdid,String us);
    List<Favorite> searchActive(String keyword,String us);
    void add(Favorite fv);
    Favorite findById(Long id);
    void delete(Favorite fv);
}
