package com.cts.tm.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.tm.model.Task;
@Repository
public interface ITaskRepository extends CrudRepository<Task, Long>{

	@Query(value="SELECT * FROM task_table WHERE"
			+ " UPPER(task) = IFNULL(:task,UPPER(task))"
			+ " AND (parent_id_fk IN (SELECT parent_id FROM parent_task_table WHERE"
			+ "	UPPER(parent_task) = IFNULL(UPPER(:parentTask), UPPER(parent_task))))"
			+ " AND ((priority >= :priorityStart OR :priorityStart = 0) "
			+ "	AND (priority <= :priorityTo OR :priorityTo = 0 ))"
			+ " AND (start_date >= :startDate OR :startDate IS NULL)"
			+ " AND (end_date <= :endDate OR :endDate IS NULL)", nativeQuery=true)			
	public List<Task> searchTask(@Param("task") String task, @Param("parentTask") String parentTask,
			@Param("priorityStart") Integer priorityStart, @Param("priorityTo") Integer priorityTo,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	 @Transactional
	 public Long deleteByTaskId(Long taskId)throws Exception;
	 
	 public Task findByTaskId(Long taskId) throws Exception;
}