package com.example.assignment.service.impl;

import com.example.assignment.JPAUtil;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    EntityManager em = JPAUtil.getEntityManager();

    @Override
    public Video findById(String id) {
        //TODO
        return null;
    }

    @Override
    public void add(Video m) {
        //TODO
        return;
    }

    @Override
    public void update(Video m) {
        //TODO
        return;
    }

    @Override
    public void deleteById(Video vd) {

    }

    @Override
    public List<Video> findAll() {
        //TODO
        return null;
    }

    @Override
    public List<Video> findAllActive() {
        return null;
    }

    @Override
    public List<Video> search(String keyword) {
        //TODO
        return null;
    }

    @Override
    public List<Video> searchActive(String keyword) {
        return null;
    }

    @Override
    public List<Video> searchFavorite(String userId, String keyword) {
        //TODO
        return null;
    }

    @Override
    public List<Video> fillFavorite(String userId, String keyword) {
        return null;
    }
}
