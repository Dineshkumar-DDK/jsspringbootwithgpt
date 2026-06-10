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
	
}
