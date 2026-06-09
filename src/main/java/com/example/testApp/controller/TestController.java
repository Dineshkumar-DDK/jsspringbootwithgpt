package com.example.testApp.controller;

import java.util.ArrayList;
import java.util.List;	
import com.example.testApp.services.TaskService;
import com.example.testApp.model.Tasks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/hello")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/tasks")
	public List<Tasks> getTasks() {
		return  TaskService.getTasks();
	}
	
	
	@PostMapping("/tasks")
	public List<Tasks> saveTasks(@RequestBody Tasks task) {
		tasks.add(task);
		return tasks;
	}
	
	@PutMapping("/tasks/{id}") // if the request body don't have class to handle it we need to add setter for id and no argument constrcutor so that the jvm creates the id - refer chat gpt for the definition
	public String updateTasks(@PathVariable Long id,@RequestBody Tasks updatedTask) {

	    System.out.println("METHOD ENTERED");
		for(Tasks task:tasks) {
			if(task.getId() == id) {
				task.setName(updatedTask.getName());
				return "Task with id:"+id+" updated succesfully";
			}
		}
		return "Task with id:"+id+" not found";
	}
}
	
	

