package com.nurs_projects.springjsrest.dao;

import com.nurs_projects.springjsrest.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select distinct u from User u left join fetch u.roles", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(Long id) {
        TypedQuery<User> tq = entityManager.createQuery("select distinct u from User u left join fetch u.roles WHERE u.id=:param", User.class);
        return Optional.of(tq.setParameter("param", id).getSingleResult()).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.getReference(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserByUsername(String name) {
        TypedQuery<User> tq = entityManager.createQuery("select distinct u from User u left join fetch u.roles WHERE u.username=:param", User.class);
        return tq.setParameter("param", name).getSingleResult();
    }
}
