package com.example.assignment.service;

import com.example.assignment.entity.User;

import java.util.List;

public interface UserInf {
    void add(User u);
    User findById(String id);
    User findByAdmin(String id);
    List<User> findAll();
    void delete(User u);
    void update(User u);
}
