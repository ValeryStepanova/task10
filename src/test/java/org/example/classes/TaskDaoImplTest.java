package org.example.classes;

import org.example.dao.interfaces.classes.TaskDaoImpl;
import org.example.entity.Task;
import org.example.hibernate.HibernateUtil;
import org.example.utils.MockUtils;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class TaskDaoImplTest {
    private final TaskDaoImpl taskDao = new TaskDaoImpl();

    @Test
    void create() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Task task = MockUtils.buildTask();
        taskDao.create(task);
        Task expectTask = entityManager.find(Task.class, 1);
        entityManager.getTransaction().commit();
        assertEquals(expectTask.getName(), task.getName());
        assertEquals(expectTask.getDescription(), task.getDescription());
        entityManager.close();
    }

    @Test
    void update() {
        Task task = MockUtils.buildTask();
        taskDao.create(task);
        String name = task.getName();
        task.setName("gfd");
        taskDao.update(task, Task.class, 1);
        assertNotEquals(name, task.getName());
    }

    @Test
    void read() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Task task = MockUtils.buildTask();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        Task expectTask = taskDao.read(2, Task.class);
        assertEquals(expectTask.getName(), task.getName());
        assertEquals(expectTask.getDescription(), task.getDescription());
        entityManager.close();
    }

    @Test
    void delete() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Task task = MockUtils.buildTask();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        Task expectTask = taskDao.delete(1, Task.class);
        assertEquals(expectTask.getName(), task.getName());
        assertEquals(expectTask.getDescription(), task.getDescription());
        entityManager.close();
    }

    @Test
    void isNull() {
        Task task = MockUtils.buildTask();
        assertNotEquals(null, taskDao.isNull(task));
    }
}