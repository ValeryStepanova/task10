package org.example.classes;

import org.example.dao.interfaces.Dao;
import org.example.hibernate.HibernateUtil;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DaoImpl<T> implements Dao<T> {
    @Override
    public void create(T obj) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public T update(T obj, Class<T> tClass, int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T realObj = entityManager.find(tClass, id);
        if (isNull(obj)) {
            entityManager.close();
            return null;
        }
        else {
            Field[] fields = realObj.getClass().getDeclaredFields();
            Arrays.stream(fields)
                    .peek(field -> field.setAccessible(true))
                    .filter(field -> field.isAnnotationPresent(Column.class))
                    .forEach(field -> {
                        try {
                            field.set(realObj, field.get(obj));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    });
            entityManager.merge(realObj);
            entityManager.getTransaction().commit();
            entityManager.close();
            return realObj;
        }
    }

    @Override
    public T read(int id, Class<T> tClass) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T obj = entityManager.find(tClass, id);
        if(isNull(obj)) {
            entityManager.close();
            return null;
        }else{
            entityManager.getTransaction().commit();
            entityManager.close();
            return obj;
        }
    }

    @Override
    public void delete(int id, Class<T> tClass) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T obj = entityManager.find(tClass, id);
        if(isNull(obj)){
            entityManager.close();
        }else{
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    public boolean isNull(T obj) {
        if (null == obj) {
            System.out.println("Не найдено");
            return true;
        }
        return false;
    }
}
