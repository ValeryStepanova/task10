package org.example;

import org.example.classes.DaoImpl;
import org.example.classes.HomeTaskDaoImpl;
import org.example.classes.TaskDaoImpl;
import org.example.classes.WorkTaskDaoImpl;
import org.example.entity.HomeTask;
import org.example.entity.Task;
import org.example.entity.WorkTask;
import org.example.entity.embeddable.Address;

public class Main {
    public static void main(String[] args) {
        Address home = Address.builder().city("Minsk").street("ffff").build();
        HomeTask homeTask = new HomeTask();
        homeTask.setName("Hometask10");
        homeTask.setDescription("Hard");
        homeTask.setAddress(home);

        TaskDaoImpl taskDao = new TaskDaoImpl();
        Task task = Task.builder().name("Task1").description("gffgf").build();
        taskDao.create(task);

        HomeTaskDaoImpl homeTaskDao = new HomeTaskDaoImpl();
        homeTaskDao.create(homeTask);

        WorkTask workTask = new WorkTask();
        workTask.setName("WorkTask10");
        workTask.setDescription("ggg");
        workTask.setCost(100);

        WorkTaskDaoImpl workTaskDao = new WorkTaskDaoImpl();
       workTaskDao.create(workTask);

    }
}