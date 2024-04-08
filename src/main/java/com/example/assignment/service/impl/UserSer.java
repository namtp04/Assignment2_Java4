package com.example.assignment.service.impl;

import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.User;
import com.example.assignment.service.UserInf;
import com.example.assignment.ultility.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UserSer implements UserInf {

    @Override
    public void add(User u) {
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public User findById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public User findByAdmin(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "SELECT f FROM User f where f.id=:id and f.admin = True";
        try {
            Query q = em.createQuery(sql, User.class);
            q.setParameter("id",id);
            User fv = (User) q.getSingleResult();
            return fv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<User> findAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "SELECT f FROM User f";
        try {
            Query q = em.createQuery(sql, User.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(User u) {
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    @Override
    public void update(User u) {
        EntityManager em = HibernateUtil.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }
}
