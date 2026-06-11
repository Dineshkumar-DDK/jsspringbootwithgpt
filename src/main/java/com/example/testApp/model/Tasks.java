package com.example.testApp.model;

public class Tasks{
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
	
	public Long getId() {
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
