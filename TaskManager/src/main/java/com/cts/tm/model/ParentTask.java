package com.cts.tm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="parent_task_table")
public class ParentTask {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="parent_id")
	private long parentId;
		
	@Column(name="parent_task")
	private String parentTask;

	@OneToMany(mappedBy="parentTask",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<Task> taskList;
	
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	public List<Task> getList() {
		return taskList;
	}
	public void setList(List<Task> taskList) {
		this.taskList = taskList;
	}
}