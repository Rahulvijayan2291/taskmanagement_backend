package com.spring.fullstackproject.entity;




import org.springframework.data.mongodb.core.mapping.Document;






//collection name in database
@Document(collection = "task_info")

  public class TaskData {
    
    private String id;
   
    private String name;
    
    private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskData(String id, String name,String status) {
		super();
		this.id = id;
		this.name = name;
		this.status=status;
	}

	@Override
	public String toString() {
		return "TaskData [id=" + id + ", name=" + name + ",status="+status+"]";
	}
   
    
   

   

	

	


	






	

}
