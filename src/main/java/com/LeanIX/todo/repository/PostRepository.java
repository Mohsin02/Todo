package com.LeanIX.todo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.LeanIX.todo.models.TODOClass;



@Repository
public interface PostRepository extends JpaRepository<TODOClass, Long>{

}