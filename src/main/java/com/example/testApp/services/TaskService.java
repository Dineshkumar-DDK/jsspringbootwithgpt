package com.example.testApp.services;

import java.util.List;
import java.util.ArrayList;
import com.example.testApp.model.Tasks;

public class TaskService {
    private List<Tasks> tasks = new ArrayList<>();

    public List<Tasks> getTasks(){
        return tasks;
    }

    public List<Tasks> addTasks(Tasks task){
        tasks.add(task);
        return tasks;
    }
}
