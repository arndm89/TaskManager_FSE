package com.cts.tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.tm.service.ITaskService;
import com.cts.tm.vo.CustomPropertyVO;
import com.cts.tm.vo.GenericResponseVO;
import com.cts.tm.vo.TaskVO;
import com.cts.tm.vo.ValidateVO;

@CrossOrigin("*")
@RestController
public class AddTaskController {
	@Autowired private CustomPropertyVO property;
	
	@Autowired private ITaskService iTaskService;

	/*@RequestMapping(value="/test", method=RequestMethod.GET, produces="application/json")
	public ParentTask getTest() {	//	 this si for testing purpose
		
		ParentTask pt = new ParentTask();
		pt.setParentId(1l);
		pt.setParentTask("A");
		
		return pt;
	}*/
	
	@RequestMapping(value="/createTask", method=RequestMethod.POST)
	public GenericResponseVO createTask(@RequestBody TaskVO taskVo) {
		String s = "";
		GenericResponseVO responseVo = new GenericResponseVO();
		try {
			ValidateVO validateVO = taskVo.isNull();
			if(validateVO.isValid()) {
				s = iTaskService.createTask(taskVo);
				if(s.equalsIgnoreCase(property.success)) {
					responseVo.setStatus(property.success);
					responseVo.setMsg(property.taskCreationSuccessfull);
				}else {
					responseVo.setStatus(property.failure);
					responseVo.setMsg(property.taskCreationFail);
				}
			}else {
				responseVo.setStatus(property.failure);
				responseVo.setMsg(property.taskCreationFail);
				responseVo.setErrorMsg(validateVO.getMsg());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			responseVo.setStatus(property.error);
			responseVo.setMsg(property.taskCreationFail);
			responseVo.setErrorMsg(e.getLocalizedMessage());
		}
		return responseVo;
	}
	
	
	
	
}
