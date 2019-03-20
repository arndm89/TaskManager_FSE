package com.cts.tm.service;

import java.util.List;

import com.cts.tm.model.Task;
import com.cts.tm.vo.SearchTaskVO;
import com.cts.tm.vo.TaskVO;

public interface ITaskService {
	
	public String createTask(TaskVO taskVo)throws Exception;
	
	public List<SearchTaskVO> searchTask(SearchTaskVO searchVO) throws Exception;
	
	public String deleteTask(int taskId)throws Exception;

	public Task getTaskById(Integer taskId) throws Exception;

	public String updateTask(TaskVO taskVo) throws Exception;
}
