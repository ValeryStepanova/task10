package org.example;

import org.example.classes.DaoImpl;
import org.example.classes.HomeTaskDaoImpl;
import org.example.classes.WorkTaskDaoImpl;
import org.example.dao.interfaces.WorkTaskDao;
import org.example.entity.HomeTask;
import org.example.entity.Task;
import org.example.entity.WorkTask;
import org.example.entity.embeddable.Address;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Address home = Address.builder().city("Minsk").street("ffff").build();
        HomeTask homeTask = new HomeTask();
        homeTask.setName("task10");
        homeTask.setDescription("Hard");
        homeTask.setAddress(home);

        HomeTaskDaoImpl homeTaskDao = new HomeTaskDaoImpl();
       // homeTaskDao.create(homeTask);

        WorkTask workTask = new WorkTask();
        workTask.setName("WorkTask10");
        workTask.setDescription("ggg");
        workTask.setCost(100);

        WorkTaskDaoImpl workTaskDao = new WorkTaskDaoImpl();
      //  workTaskDao.create(workTask);

        workTask.setCost(43);
        workTaskDao.update(workTask, WorkTask.class, 3);
    }
}