package org.example.dao.interfaces.classes;

import org.example.dao.interfaces.HomeTaskDao;
import org.example.entity.HomeTask;

public class HomeTaskDaoImpl extends DaoImpl<HomeTask> implements HomeTaskDao {
    @Override
    public void create(HomeTask obj) {
        super.create(obj);
    }

    @Override
    public HomeTask update(HomeTask obj, Class<HomeTask> homeTaskClass, int id) {
        return super.update(obj, homeTaskClass, id);
    }

    @Override
    public HomeTask read(int id, Class<HomeTask> homeTaskClass) {
        return super.read(id, homeTaskClass);
    }

    @Override
    public HomeTask delete(int id, Class<HomeTask> homeTaskClass) {
        return super.delete(id, homeTaskClass);
    }

    @Override
    public boolean isNull(HomeTask obj) {
        return super.isNull(obj);
    }
}
