package com.cts.tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.tm.model.Task;
import com.cts.tm.service.ITaskService;
import com.cts.tm.vo.CustomPropertyVO;
import com.cts.tm.vo.GenericResponseVO;
import com.cts.tm.vo.SearchTaskVO;
import com.cts.tm.vo.TaskVO;
import com.cts.tm.vo.ValidateVO;

@CrossOrigin("*")
@RestController
public class EditTaskController {
	@Autowired private CustomPropertyVO property;
	
	@Autowired private ITaskService iTaskService;

	@RequestMapping(value="/getTaskById", method=RequestMethod.GET)
	public GenericResponseVO getTaskById(@RequestParam("taskId") Integer taskId) {
		Task task = null;
		GenericResponseVO vo = new GenericResponseVO();
		try {
			if(taskId != null && taskId != 0) {
				task = iTaskService.getTaskById(taskId);
				if(task != null) {
					SearchTaskVO model = new SearchTaskVO();
					model.setTaskId(taskId);
					model.setTask(task.getTask());
					model.setParentTask(task.getParentTask().getParentTask());
					model.setPriority(task.getPriority());
					model.setStartDate(task.getStartDate());
					model.setEndDate(task.getEndDate());
					
					vo.setTaskVO(model);					
					vo.setStatus(property.success);
				}
			}else {
				vo.setStatus(property.notFound);
				vo.setMsg(property.taskNotFound);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStatus(property.error);
			vo.setMsg(property.taskNotFound);
		}
		return vo;
	}
	
	@RequestMapping(value="/updateTask", method=RequestMethod.PUT)
	public GenericResponseVO editTask(@RequestBody TaskVO taskVo) {
		String s = "";
		GenericResponseVO responseVo = new GenericResponseVO();
		try {
			
			if(taskVo.getTaskId() != null && taskVo.getTaskId() != 0) {
				ValidateVO validateVO = taskVo.isNull();
				
				if(validateVO.isValid()) {
					s = iTaskService.updateTask(taskVo);
					
					if(s.equalsIgnoreCase(property.success)) {
						responseVo.setStatus(property.success);
						responseVo.setMsg(property.taskUpdateSuccess);
					}else {
						responseVo.setStatus(property.failure);
						responseVo.setMsg(property.taskUpdateFail);
					}
				}else {
					responseVo.setStatus(property.failure);
					responseVo.setMsg(property.taskUpdateFail);
					responseVo.setErrorMsg(validateVO.getMsg());
				}
			}else {
				responseVo.setStatus(property.failure);
				responseVo.setMsg(property.taskUpdateFail);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			responseVo.setStatus(property.error);
			responseVo.setMsg(property.taskUpdateFail);
			responseVo.setErrorMsg(e.getLocalizedMessage());
		}
		return responseVo;
	}
	
}
