package com.LeanIX.todo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.LeanIX.todo.models.TasksClass;



@Repository
public interface TaskClassRepository extends JpaRepository<TasksClass, Long>{

}