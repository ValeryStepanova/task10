package org.example.classes;

import org.example.entity.HomeTask;
import org.example.hibernate.HibernateUtil;
import org.example.utils.MockUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class HomeTaskDaoImplTest {
    private final HomeTaskDaoImpl homeTaskDao = new HomeTaskDaoImpl();

    @Test
    void create() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        HomeTask homeTask = MockUtils.buildHome();
        homeTaskDao.create(homeTask);
        HomeTask expectHome = entityManager.find(HomeTask.class, 1);
        entityManager.getTransaction().commit();
        assertEquals(expectHome.getAddress(), homeTask.getAddress());
        assertEquals(expectHome.getName(), homeTask.getName());
        assertEquals(expectHome.getDescription(), homeTask.getDescription());
        entityManager.close();
    }

    @Test
    void update() {
        HomeTask homeTask = MockUtils.buildHome();
        homeTaskDao.create(homeTask);
        String name = homeTask.getName();
        homeTask.setName("gfd");
        homeTaskDao.update(homeTask, HomeTask.class, 1);
        assertNotEquals(name, homeTask.getName());
    }

    @Test
    void read() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        HomeTask homeTask = MockUtils.buildHome();
        entityManager.persist(homeTask);
        entityManager.getTransaction().commit();
        HomeTask expectHome = homeTaskDao.read(2, HomeTask.class);
        assertEquals(expectHome.getAddress(), homeTask.getAddress());
        assertEquals(expectHome.getName(), homeTask.getName());
        assertEquals(expectHome.getDescription(), homeTask.getDescription());
        entityManager.close();
    }

    @Test
    void delete() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        HomeTask homeTask = MockUtils.buildHome();
        entityManager.persist(homeTask);
        entityManager.getTransaction().commit();
        HomeTask expectHome = homeTaskDao.delete(1, HomeTask.class);
        assertEquals(expectHome.getAddress(), homeTask.getAddress());
        assertEquals(expectHome.getName(), homeTask.getName());
        assertEquals(expectHome.getDescription(), homeTask.getDescription());
        entityManager.close();
    }

    @Test
    void isNull() {
        HomeTask homeTask = MockUtils.buildHome();
        assertNotEquals(null, homeTaskDao.isNull(homeTask));
    }
}