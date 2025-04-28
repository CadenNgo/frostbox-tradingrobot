package com.frostbox.tradingrobot.frostbox_tradingrobot.service.Utilities;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
public class PostgreSQLBuilder {

     @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public <T> T insertIntoDatabase(T entity) {
        try {
            entityManager.persist(entity); // directly save
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
