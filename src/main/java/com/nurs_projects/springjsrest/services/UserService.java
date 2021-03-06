package com.nurs_projects.springjsrest.services;

import com.nurs_projects.springjsrest.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void saveUsers(User ... user);

    User getUser(Long id);

    void deleteUser(Long id);
}
