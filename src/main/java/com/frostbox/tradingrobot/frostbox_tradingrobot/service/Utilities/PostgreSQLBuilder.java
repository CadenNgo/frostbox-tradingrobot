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
        if (entity instanceof Object[] array) { // handle arrays
            for (Object obj : array) {
                entityManager.merge(obj);
            }
        } else if (entity instanceof Iterable) { // handle List, Set, etc.
            for (Object obj : (Iterable<?>) entity) {
                entityManager.merge(obj);
            }
        } else { // single object
            entityManager.merge(entity);
        }
        return entity;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}
