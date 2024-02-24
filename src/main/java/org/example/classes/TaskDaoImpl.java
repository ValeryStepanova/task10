package org.example.classes;

import org.example.dao.interfaces.TaskDao;
import org.example.entity.HomeTask;
import org.example.entity.Task;

public class TaskDaoImpl extends DaoImpl<Task> implements TaskDao {
    @Override
    public void create(Task obj) {
        super.create(obj);
    }

    @Override
    public Task update(Task obj, Class<Task> taskClass, int id) {
        return super.update(obj, taskClass, id);
    }

    @Override
    public Task read(int id, Class<Task> taskClass) {
        return super.read(id, taskClass);
    }

    @Override
    public Task delete(int id, Class<Task> taskClass) {
        return super.delete(id, taskClass);
    }

    @Override
    public boolean isNull(Task obj) {
        return super.isNull(obj);
    }
}
