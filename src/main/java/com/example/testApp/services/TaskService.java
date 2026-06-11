package com.example.testApp.services;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Tasks> editTask(Tasks currentTask){
		for(Tasks task:tasks) {
			if(task.getId() == currentTask.getId() ) {
				task.setName(currentTask.getName());
				return tasks;
			}
		}
		return null;
	}

    public Tasks getTaskById(Long id){
        for(Tasks task:tasks){
            if(task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }
	
    public String deleteTask(Long id){
        List<Tasks> updatedTask = tasks;
        for(Tasks task:updatedTask){
            if(task.getId().equals(id)){
                updatedTask.remove(task);
                tasks = updatedTask;
                return "Task with id:"+id+" deleted successfully";
            }
        }
        return "Task with id:"+id+" Not founded";
    }
}
