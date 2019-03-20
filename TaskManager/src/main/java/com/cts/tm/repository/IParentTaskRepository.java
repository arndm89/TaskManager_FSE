package com.cts.tm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.tm.model.ParentTask;
@Repository
public interface IParentTaskRepository extends CrudRepository<ParentTask, Long>{

	ParentTask findByParentTask(String parentTask);
	
	/*@Query(value="SELECT * from Task where "
			+ "upper(o.task) = IFNULL(:task,upper(o.task)) "
			+ "AND priority = :priority OR :priority = 0 ", nativeQuery=true)			
	List<ParentTask> searchTask(@Param("task") String task, @Param("priority") Integer priority);
	
	*/
	
	
	
	
	
}
