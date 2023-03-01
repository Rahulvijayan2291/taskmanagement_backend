package com.spring.fullstackproject.service;

import com.spring.fullstackproject.Dao.TaskDataRepository;
import com.spring.fullstackproject.entity.TaskData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskServiceImpl implements TaskService {
    private TaskDataRepository Objectrepository;
    //ConstructorInjection -here the object of TaskDataRepository(interface) will be injected
    public TaskServiceImpl( TaskDataRepository theTaskDataRepository) {
    	Objectrepository = theTaskDataRepository;
    }
     //it is a method to save data,methods from spring data jpa used here like save,findByOrderByNameAsc() methods;
    public void Save(TaskData taskdata){
    	Objectrepository.save(taskdata);
       //save is a method from hibernate and Spring data jpa
    }
    
    public void Save1(TaskData tasks) {
    	
    	 Objectrepository.save(tasks);
	
    	
    };

    public void deleteById(String id){
    	Objectrepository.deleteById(id);
       //save is a method from hibernate and Spring data jpa
    }


	@Override
	public List<TaskData> findByOrderByIdAsc() {
   	List<TaskData> tasklist=Objectrepository. findByOrderByIdAsc();

		return tasklist;
    }
}
	

	

