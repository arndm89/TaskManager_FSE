package com.cts.tm.vo;

import java.util.Date;

import com.cts.tm.util.Utility;

public class TaskVO {
	Integer taskId;
	String task;
	Integer range;
	String parentTask;
	Date startDate;
	Date endDate;
	
	public ValidateVO isNull() {
		
		ValidateVO vo = new ValidateVO();
		StringBuilder msg = new StringBuilder();
		boolean flag = true;
		
		if(!Utility.isValidString(this.task, 1, 500)) {
			msg.append("Length of a Task should be among 1 - 500.<br>");
			flag = false;
		}
		if(!Utility.isValidString(this.parentTask, 1, 500)) {
			msg.append("Length of a Parent Task should be among 1 - 500.<br>");
			flag = false;
		}
		if(this.startDate == null) {
			msg.append("Start date can not be blank.<br>");
			flag = false;
		}
		if(this.endDate == null) {
			msg.append("End date can not be blank.<br>");
			flag = false;
		}
		vo.setValid(flag);
		vo.setMsg(msg.toString());
		return vo;
	}
	
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Integer getRange() {
		return range;
	}
	public void setRange(Integer range) {
		this.range = range;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
}