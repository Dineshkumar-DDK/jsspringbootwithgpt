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
	
	public Boolean editTask(Tasks currentTask, Long id){
		for(Tasks task:tasks) {
		//	if(task.getId() == id ) {  // oru vela rendu sidum objectaagita dangerous so - .equals
			if(task.getId().equals(id)) {
				task.setName(currentTask.getName());
				return true;
			}
		}
		return false;
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
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).getId().equals(id)){
                tasks.remove(i);
                return "Task with id:"+id+"deleted";  
            }
        }
        
        return "Task with id:"+id+" Not founded";
    }
}
