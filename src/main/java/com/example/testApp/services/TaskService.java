package com.example.testApp.services;

import java.util.ArrayList;
import java.util.List;

import com.example.testApp.model.Tasks;

public class TaskService {
	
	private List<Tasks> tasks = new ArrayList<>();
	
	private List<Tasks>  updatedTasks  = tasks;
	
	public List<Tasks> getTasks(){
		return updatedTasks;
	}
	
	public List<Tasks> addTasks(Tasks task){
		tasks.add(task);
		updatedTasks = tasks;
		return updatedTasks;
	}
	
	public List<Tasks> editTask(Tasks currentTask,String id){
		for(Tasks task:tasks) {
			if(task.getId() == currentTask.getId() ) {
				task.setName(currentTask.getName());
				break;
			}
		}
		
		return tasks;
	}
	
}
