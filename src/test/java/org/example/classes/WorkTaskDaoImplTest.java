package org.example.classes;

import org.example.dao.interfaces.classes.WorkTaskDaoImpl;
import org.example.entity.WorkTask;
import org.example.hibernate.HibernateUtil;
import org.example.utils.MockUtils;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class WorkTaskDaoImplTest {
    private final WorkTaskDaoImpl workTaskDao = new WorkTaskDaoImpl();

    @Test
    void create() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        WorkTask workTask = MockUtils.buildWorl();
        workTaskDao.create(workTask);
        WorkTask workTask1 = entityManager.find(WorkTask.class, 1);
        entityManager.getTransaction().commit();
        assertEquals(workTask1.getCost(), workTask.getCost());
        assertEquals(workTask1.getName(), workTask.getName());
        assertEquals(workTask1.getDescription(), workTask.getDescription());
        entityManager.close();
    }

    @Test
    void update() {
        WorkTask workTask = MockUtils.buildWorl();
        workTaskDao.create(workTask);
        String name = workTask.getName();
        workTask.setName("gfd");
        workTaskDao.update(workTask, WorkTask.class, 2);
        assertNotEquals(name, workTask.getName());
    }

    @Test
    void read() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        WorkTask workTask = MockUtils.buildWorl();
        entityManager.persist(workTask);
        entityManager.getTransaction().commit();
        WorkTask workTask1 = workTaskDao.read(3, WorkTask.class);
        assertEquals(workTask1.getCost(), workTask.getCost());
        assertEquals(workTask1.getName(), workTask.getName());
        assertEquals(workTask1.getDescription(), workTask.getDescription());
        entityManager.close();
    }

    @Test
    void delete() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        WorkTask workTask = MockUtils.buildWorl();
       // entityManager.persist(workTask);
        entityManager.getTransaction().commit();
        WorkTask workTask1 = workTaskDao.delete(1, WorkTask.class);
        assertEquals(workTask1.getCost(), workTask.getCost());
        assertEquals(workTask1.getName(), workTask.getName());
        assertEquals(workTask1.getDescription(), workTask.getDescription());
        entityManager.close();
    }

    @Test
    void isNull() {
        WorkTask workTask = MockUtils.buildWorl();
        assertNotEquals(null, workTaskDao.isNull(workTask));
    }
}