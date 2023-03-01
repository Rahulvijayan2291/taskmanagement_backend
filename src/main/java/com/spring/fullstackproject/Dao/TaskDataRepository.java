package com.spring.fullstackproject.Dao;


import com.spring.fullstackproject.entity.TaskData;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskDataRepository extends MongoRepository<TaskData, String>{

//SpringDataJpa Method to findData from Table by ascending order of name
	List<TaskData> findByOrderByIdAsc();

//	void UpdateById(String id);
}
