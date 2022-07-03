package com.LeanIX.todo.payload.request;

import java.util.List;
import java.util.Set;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class ToDoEntity {
	
	
	  @NotBlank
	  @Size(max = 20)
	  private String name;
	  
	  @NotBlank
	  @Size(max = 2000)
	  private String description;
	  
	  private List<TasksEntity> task;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TasksEntity> getTask() {
		return task;
	}

	public void setTask(List<TasksEntity> task) {
		this.task = task;
	}

}
