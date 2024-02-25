package org.example.dao.interfaces.classes;

import org.example.dao.interfaces.WorkTaskDao;
import org.example.entity.WorkTask;

public class WorkTaskDaoImpl extends DaoImpl<WorkTask> implements WorkTaskDao {
    @Override
    public void create(WorkTask obj) {
        super.create(obj);
    }

    @Override
    public WorkTask update(WorkTask obj, Class<WorkTask> workTaskClass, int id) {
        return super.update(obj, workTaskClass, id);
    }

    @Override
    public WorkTask read(int id, Class<WorkTask> workTaskClass) {
        return super.read(id, workTaskClass);
    }

    @Override
    public WorkTask delete(int id, Class<WorkTask> workTaskClass) {
        return super.delete(id, workTaskClass);
    }

    @Override
    public boolean isNull(WorkTask obj) {
        return super.isNull(obj);
    }
}
