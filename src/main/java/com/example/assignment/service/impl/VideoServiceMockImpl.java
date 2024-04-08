package com.example.assignment.service.impl;

import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import com.example.assignment.ultility.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class VideoServiceMockImpl implements VideoService {
    List<Video> movieList = new ArrayList<>();

    @Override
    public List<Video> findAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "select m from Video m";
        try {
            Query q = em.createQuery(sql, Video.class);
            movieList = q.getResultList();
            return movieList;

        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findAllActive() {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "select m from Video m where m.active = true";
        try {
            Query q = em.createQuery(sql, Video.class);
            movieList = q.getResultList();
            return movieList;

        } finally {
            em.close();
        }
    }

    @Override
    public Video findById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(Video.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void add(Video m) {
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public void update(Video m) {
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Video vd) {
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(vd);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }


    @Override
    public List<Video> search(String keyword) {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "select vd from Video vd where vd.title like :kw";
        try {
            Query q = em.createQuery(sql, Video.class);
            q.setParameter("kw", "%" + keyword + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> searchActive(String keyword) {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "select vd from Video vd where vd.title like :kw and vd.active=true";
        try {
            Query q = em.createQuery(sql, Video.class);
            q.setParameter("kw", "%" + keyword + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> searchFavorite(String userId, String keyword) {
        List<Video> items = new ArrayList<>();
        for (Video m : movieList) {
            if (m.getTitle() == null) continue;
            if (m.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                items.add(m);
            }
        }
        return items;
    }

    @Override
    public List<Video> fillFavorite(String userId, String keyword) {
        List<Video> items = new ArrayList<>();
        for (Video m : movieList) {
            if (m.getTitle() == null) continue;
            if (m.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                items.add(m);
            }
        }
        return items;
    }
}
