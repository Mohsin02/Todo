package com.LeanIX.todo.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TasksEntity {
	
	 @NotBlank
	  @Size(max = 20)
	  private String name;
	  
	  @NotBlank
	  @Size(max = 2000)
	  private String description;

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
	  
	  
	  

}
