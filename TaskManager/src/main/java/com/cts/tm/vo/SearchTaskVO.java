package com.cts.tm.vo;

import java.util.Date;

import com.cts.tm.util.Utility;

public class SearchTaskVO {
	String task;
	Integer taskId;
	String parentTask;
	int priorityStart;
	int priorityTo;
	Date startDate;
	Date endDate;
	
	int priority;	//	 for search response
	
	public SearchTaskVO() {}
	public SearchTaskVO(String task, Integer taskId, String parentTask, 
			Date startDate, Date endDate, int priority) {
		this.task = task;
		this.taskId = taskId;
		this.parentTask = parentTask;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		//task = task != null && task.length() == 0 ? null : task;
		task = Utility.isEmptyStr(task) ? null : task;
		this.task = task;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		parentTask = Utility.isEmptyStr(parentTask) ? null : parentTask;
		this.parentTask = parentTask;
	}
	public int getPriorityStart() {
		return priorityStart;
	}
	public void setPriorityStart(int priorityStart) {
		this.priorityStart = priorityStart;
	}
	public void setPriorityStart(String priorityStart) {
		
		this.priorityStart = Utility.isEmptyStr(priorityStart) ? 0: Integer.parseInt(priorityStart);
	}
	public int getPriorityTo() {
		return priorityTo;
	}
	public void setPriorityTo(int priorityTo) {
		this.priorityTo = priorityTo;
	}
	public void setPriorityTo(String priorityTo) {
		this.priorityTo = Utility.isEmptyStr(priorityTo) ? 0 : Integer.parseInt(priorityTo);
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = Utility.isEmptyStr(startDate) ? null : Utility.parseDate(startDate);
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = Utility.isEmptyStr(endDate) ? null : Utility.parseDate(endDate);;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
}