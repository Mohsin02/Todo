package com.LeanIX.todo.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TODO")
public class TODOClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid", referencedColumnName = "id")
    List < TasksClass > tasks = new ArrayList < > ();

    public TODOClass() {

    }

    public TODOClass(String title, String description) {
        super();
        this.name = title;
        this.description = description;
    }
    
    public TODOClass(String title, String description, List < TasksClass > task) {
        super();
        this.name = title;
        this.description = description;
        this.tasks = task;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

	public List<TasksClass> getComments() {
		return tasks;
	}

	public void setComments(List<TasksClass> comments) {
		this.tasks = comments;
	}

    
}