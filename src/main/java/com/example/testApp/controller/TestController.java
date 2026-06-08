package com.example.testApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class Tasks{
	private Long id;
	private String name;
	
	
	public Tasks(Long id, String name){
		this.id=id;
		this.name=name;
	}
	
	public Tasks() {
		
	}
	
	// getter setter podalana - empty object daan varum while hitting the /tasks endpoint
	// solution - getter and setter 
	// reference - https://chatgpt.com/share/6a1f703e-1298-83a6-a909-c9a13fad93e2 ( aikyne@gmail.com ) 
	// search for - because Spring/Jackson can only serialize fields that it can access.
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	public void setId(Long id) {
		this.id=id;
	}
	
}

@RestController
public class TestController {
	private List<Tasks> tasks = new ArrayList<>();
	@GetMapping("/hello")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/tasks")
	public List<Tasks> getTasks() {
		return  tasks;
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
	
	

