package com.example.assignment.service.impl;

import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;
import com.example.assignment.ultility.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UserServiceMockImpl implements UserService {
    @Override
    public boolean checkUser(String username, String password) {
        EntityManager em = HibernateUtil.createEntityManager();
        String sql = "select u from User u where u.id = :usn and u.password =:pwd";
        try {
            Query q = em.createQuery(sql, User.class);
            q.setParameter("usn", username);
            q.setParameter("pwd", password);
            List<User> resultList = q.getResultList();
            if (!resultList.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } finally {
            em.close();

        }
    }
}
