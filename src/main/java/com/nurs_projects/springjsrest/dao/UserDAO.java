package com.nurs_projects.springjsrest.dao;



import com.nurs_projects.springjsrest.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    User getUserByUsername(String name);
}
