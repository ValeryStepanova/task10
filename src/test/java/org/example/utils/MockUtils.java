package org.example.utils;

import org.example.entity.HomeTask;
import org.example.entity.Task;
import org.example.entity.WorkTask;
import org.example.entity.embeddable.Address;

public class MockUtils {
    public static Task buildTask(){
        return Task.builder().name("gfg").description("gdfg").build();
    }

    public static WorkTask buildWorl(){
        WorkTask workTask = new WorkTask();
        workTask.setName("WorkTask10");
        workTask.setDescription("ggg");
        workTask.setCost(100);
        return workTask;
    }

    public static HomeTask buildHome(){
        Address home = Address.builder().city("Minsk").street("ffff").build();
        HomeTask homeTask = new HomeTask();
        homeTask.setName("task10");
        homeTask.setDescription("Hard");
        homeTask.setAddress(home);
        return homeTask;
    }
}
