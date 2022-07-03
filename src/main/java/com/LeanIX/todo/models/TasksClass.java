package com.LeanIX.todo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class TasksClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String  description;
    private String  name;

    public TasksClass() {

    }

    
    public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public TasksClass(String name,String description) {
        super();
        this.name = name;
        this.description= description;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
}