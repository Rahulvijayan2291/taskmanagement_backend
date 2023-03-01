package com.spring.fullstackproject.service;

import java.util.List;

import com.spring.fullstackproject.entity.TaskData;

public interface TaskService {
    public void Save(TaskData taskdata);
    public void  Save1(TaskData tasks);

    List<TaskData> findByOrderByIdAsc();
	public void deleteById(String id);
}
