package com.example.assignment.service.impl;

import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.Video;
import com.example.assignment.service.FavoriteInf;
import com.example.assignment.ultility.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class FavoriteSer implements FavoriteInf {
    List<Favorite> lstFV = new ArrayList<>();

    @Override
    public List<Favorite> findAll(String us) {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "SELECT f FROM Favorite f where f.user.id= :ten";
        try {
            Query q = em.createQuery(sql, Favorite.class);
            q.setParameter("ten", us);
            lstFV = q.getResultList();
            return lstFV;
        } finally {
            em.close();
        }
    }

    @Override
    public Favorite findByVideoId(String vdid, String us) {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "SELECT f FROM Favorite f where f.user.id= :ten and f.video.id= :id";
        try {
            Query q = em.createQuery(sql, Favorite.class);
            q.setParameter("id", vdid);
            q.setParameter("ten", us);
            Favorite fv = (Favorite) q.getSingleResult();
            return fv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Favorite> searchActive(String keyword,String us) {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "select fv from Favorite fv where fv.video.title like :kw and fv.video.active=true and fv.user.id= :ten";
        try {
            Query q = em.createQuery(sql, Favorite.class);
            q.setParameter("kw", "%" + keyword + "%");
            q.setParameter("ten", us);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void add(Favorite fv) {
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(fv);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public Favorite findById(Long id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(Favorite.class, id);
        } finally {
            em.close();
        }
    }
    @Override
    public void delete(Favorite fv) {
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(fv);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }
}
