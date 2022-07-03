package com.LeanIX.todo.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LeanIX.todo.models.Role;
import com.LeanIX.todo.models.TODOClass;
//import com.LeanIX.todo.models.Tasks;
import com.LeanIX.todo.models.TasksClass;
//import com.LeanIX.todo.models.ToDo;
import com.LeanIX.todo.payload.request.SignupRequest;
import com.LeanIX.todo.payload.request.TasksEntity;
import com.LeanIX.todo.payload.request.ToDoEntity;
import com.LeanIX.todo.payload.response.MessageResponse;
import com.LeanIX.todo.repository.PostRepository;
import com.sun.xml.bind.v2.TODO;



@RestController
@RequestMapping("/api")
public class toDoController {
//	@Autowired
//	ToDoRepository toDoRepository;
//	@Autowired
//	 TaskRepository taskRepo;
	
	@Autowired
    private PostRepository postRepository;
	
	
	@GetMapping("/getTodo")
	public ResponseEntity<List<TODOClass>> firstPage() {
		
	 List<TODOClass> todo = 	postRepository.findAll();

		return new ResponseEntity<List<TODOClass>>(todo, HttpStatus.OK);
	}
	 @GetMapping(value = "/getTodo/{id}")
	    public ResponseEntity<Optional<TODOClass>>  getToDoById (@PathVariable("id") Long id)
	    {
	
		 
		 Optional<TODOClass> todo = 	postRepository.findById(id);
		 
	 return 	 new ResponseEntity<Optional<TODOClass>>(todo,HttpStatus.OK);
	    }
	 
	 @DeleteMapping(value = "/delete/{id}")
	    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

	       postRepository.deleteById(id);
	       
	       

//	        if (!isRemoved) {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }

	        return new ResponseEntity<>(id, HttpStatus.OK);
	    }
	 
	 @PutMapping("/update/{id}")
	 public ResponseEntity<TODOClass> updateEmployee(@PathVariable(value = "id") Long id,
	   @Valid @RequestBody ToDoEntity toDoRequest) throws RelationNotFoundException {
	     TODOClass todo = postRepository.findById(id)
	     .orElseThrow(() -> new RelationNotFoundException("ToDo not found for this id :: " + id));
          
	     
	     todo.setDescription(toDoRequest.getDescription());
	     todo.setName(toDoRequest.getName());
	     
	     for (TasksEntity tasks : toDoRequest.getTask()) {
			 
	    	  TasksClass comment1 = new 	TasksClass(tasks.getName(),tasks.getDescription());
	    	  todo.getComments().add(comment1);		    	
	    	}
	     
	     
	     final TODOClass updatedtoDo = postRepository.save(todo);
	     return ResponseEntity.ok(updatedtoDo);
	 }
	@PostMapping("/todo")
	public ResponseEntity<?> toDo(@Valid @RequestBody ToDoEntity toDoRequest) {
		
		    TODOClass post = new TODOClass(toDoRequest.getName(), toDoRequest.getDescription());
		    
		    
		    for (TasksEntity tasks : toDoRequest.getTask()) {
				 
		    	  TasksClass comment1 = new 	TasksClass(tasks.getName(),tasks.getDescription());
		    	  post.getComments().add(comment1);		    	
		    	}
	      


		    TODOClass id =  this.postRepository.save(post);
		    System.out.println();
		  return ResponseEntity.ok(new MessageResponse("ToDo Addedd successfully! with ID :" + id.getId()));
		
		
		
	}

}
