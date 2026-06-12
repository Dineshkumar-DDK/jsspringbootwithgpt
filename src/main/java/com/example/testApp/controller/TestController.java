package com.example.testApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.testApp.model.Tasks;
import com.example.testApp.services.TaskService;



@RestController
public class TestController {
	// controller use 
	private TaskService taskService = new TaskService();
	
	@GetMapping("/hello")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/tasks")
	public List<Tasks> getTasks() {
		return  taskService.getTasks();
	}
	
	 @GetMapping("/tasks/{id}")
	 public Tasks getTaskById(@PathVariable Long id) {
	 	return taskService.getTaskById(id);
	 }


	
	
	@PostMapping("/tasks")
	public List<Tasks> saveTasks(@RequestBody Tasks task) {
		return taskService.addTasks(task);
	}
	
//	@PutMapping("/tasks/{id}") // if the request body don't have class to handle it we need to add setter for id and no argument constrcutor so that the jvm creates the id - refer chat gpt for the definition
//	public String updateTasks(@PathVariable Long id,@RequestBody Tasks updatedTask) {
//
//	    System.out.println("METHOD ENTERED");
//		for(Tasks task:tasks) {
//			if(task.getId() == id) {
//				task.setName(updatedTask.getName());
//				return "Task with id:"+id+" updated succesfully";
//			}
//		}
//		return "Task with id:"+id+" not found";
//	}
	
	@PutMapping("/tasks/{id}")
	public String editTasks(@PathVariable Long id ,@RequestBody Tasks task){
		Boolean updated = taskService.editTask(task, id);
		if(updated){
			return "Task updated";
		}
		return "Task Not Found";
	}

	@DeleteMapping("/tasks/{id}")
	public String deleteTask(@PathVariable Long id ){
		return taskService.deleteTask(id);
	}
	
	
	
}
	
	
