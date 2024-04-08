package com.example.assignment.service;

import com.example.assignment.entity.Video;

import java.util.List;

public interface VideoService {
    List<Video> findAll();
    List<Video> findAllActive();
    Video findById(String id);
    void add(Video m);
    void update(Video m);
    void deleteById(Video vd);
    List<Video> search(String keyword);
    List<Video> searchActive(String keyword);
    List<Video> searchFavorite(String userId, String keyword);
    List<Video> fillFavorite(String userId, String keyword);
}
