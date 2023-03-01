package com.spring.fullstackproject.controller;


import com.spring.fullstackproject.Dao.TaskDataRepository;
import com.spring.fullstackproject.entity.TaskData;
import com.spring.fullstackproject.service.TaskService;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000") 
@RequestMapping("/api")

public class TaskController {
   //Constructor Injection-used to inject object of service
     private TaskService Objectservice;

    public TaskController(TaskService theTaskService) {
    	Objectservice = theTaskService;
    }
    
    @Autowired
    private TaskDataRepository Objectrepository;

   // Method to save data from api to DataBase, linked to service and serviceimpl 
    @PostMapping("/tasks")
    public ResponseEntity<TaskData>add(@RequestBody TaskData taskdata) {
   //ResponseEntity used to get Http response
    	System.out.println("hai"+ taskdata.getStatus());

    Objectservice.Save(taskdata);

    return  new ResponseEntity<>(taskdata, HttpStatus.CREATED);
    }
    
    
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TaskData> deleteList(@PathVariable String id){
    	System.out.println(id);
    	Objectservice.deleteById(id);
        
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    //Method to find Data from DataBase,linked to service and serviceimpl
    @GetMapping("/gettasks")																										
    public ResponseEntity<List<TaskData>> find(){
    	
     List<TaskData> tasklist= Objectservice.findByOrderByIdAsc();    	
     return  new ResponseEntity<>( tasklist,HttpStatus.OK);
    }
    @PutMapping("/tasks/status/{id}")
    public ResponseEntity<TaskData> UpdateStatus(@PathVariable String id,@RequestBody TaskData taskdata){
    	System.out.println(id);
    	System.out.println(taskdata.getStatus());
    	TaskData tasks = Objectrepository.findById(id).get();
    	
    	if (Objects.nonNull(taskdata.getStatus())
                && !"".equalsIgnoreCase(
                		taskdata.getStatus())) {
    		tasks.setStatus(
    				taskdata.getStatus());
            }
    	
       
    	System.out.println(taskdata.getName());


    	 Objectservice.Save1(tasks);
//    	Objectservice.UpdateById(id);
        
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
