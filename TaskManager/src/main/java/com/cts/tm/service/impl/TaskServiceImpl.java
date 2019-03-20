package com.cts.tm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.tm.model.ParentTask;
import com.cts.tm.model.Task;
import com.cts.tm.repository.IParentTaskRepository;
import com.cts.tm.repository.ITaskRepository;
import com.cts.tm.service.ITaskService;
import com.cts.tm.vo.CustomPropertyVO;
import com.cts.tm.vo.SearchTaskVO;
import com.cts.tm.vo.TaskVO;
@Service
public class TaskServiceImpl implements ITaskService{
	
	@Autowired CustomPropertyVO property;
	@Autowired IParentTaskRepository iParentTaskDao;
	@Autowired ITaskRepository iTaskDao;
	
	@Override
	public String createTask(TaskVO taskVo) throws Exception {
		String status = "failed"; 
		
		ParentTask parentTask = iParentTaskDao.findByParentTask(taskVo.getParentTask());
		
		if(parentTask == null){
			parentTask = new ParentTask();
			parentTask.setParentTask(taskVo.getParentTask());
		}
		Task task = new Task();
		task.setParentTask(parentTask);
		task.setTask(taskVo.getTask());
		task.setPriority(taskVo.getRange());
		task.setStartDate(taskVo.getStartDate());
		task.setEndDate(taskVo.getEndDate());
		
		List<Task> taskList = new ArrayList<>();
		taskList.add(task);
		parentTask.setList(taskList);
		
		status = iParentTaskDao.save(parentTask) == null ? "failed" : "success";
		return status;
	}

	@Override
	public List<SearchTaskVO> searchTask(SearchTaskVO searchTaskVO) throws Exception {
		
		List<SearchTaskVO> tasklist = null;
		List<Task> list = iTaskDao.searchTask(searchTaskVO.getTask(), 
				searchTaskVO.getParentTask(),
				searchTaskVO.getPriorityStart(),
				searchTaskVO.getPriorityTo(),
				searchTaskVO.getStartDate(),
				searchTaskVO.getEndDate());
		
		if(list != null) {
			tasklist = new ArrayList<>(list.size());
			SearchTaskVO taskVO = null;
			for(Task task : list) {
				
				taskVO = new SearchTaskVO();
				taskVO.setParentTask(task.getParentTask().getParentTask());
				taskVO.setTask(task.getTask());
				taskVO.setTaskId(task.getTaskId().intValue());
				taskVO.setPriority(task.getPriority());
				taskVO.setStartDate(task.getStartDate());
				taskVO.setEndDate(task.getEndDate());
				tasklist.add(taskVO);
			}
		}
		return tasklist;
	}
	@Override
	public String deleteTask(int taskId) throws Exception {
		Long rows = iTaskDao.deleteByTaskId((long) taskId);
		return rows > 0 ? "SUCCESS" : "NOT_FOUND";
	}

	@Override
	public Task getTaskById(Integer taskId) throws Exception {
		Task task = iTaskDao.findByTaskId(new Long(taskId));
		return task;
	}
	@Override
	public String updateTask(TaskVO taskVo) throws Exception {
		
		String status = property.failure; 
		
		Task task = iTaskDao.findByTaskId((long) taskVo.getTaskId());
		if(task == null) {
			return status;
		} else {
			task.setTaskId((long) taskVo.getTaskId()); 
			task.setTask(taskVo.getTask());
			task.getParentTask().setParentTask(taskVo.getParentTask());
			task.setPriority(taskVo.getRange());
			task.setStartDate(taskVo.getStartDate());
			task.setEndDate(taskVo.getEndDate());
		}
		status = iTaskDao.save(task) == null ? property.failure : property.success;
		return status;
	}
}
