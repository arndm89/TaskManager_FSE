package com.cts.tm.vo;

public class GenericResponseVO {
	String status;
	String msg;
	String errorMsg;
	SearchVO searchVO;
	SearchTaskVO taskVO;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public SearchVO getSearchVO() {
		return searchVO;
	}
	public void setSearchVO(SearchVO searchVO) {
		this.searchVO = searchVO;
	}
	public SearchTaskVO getTaskVO() {
		return taskVO;
	}
	public void setTaskVO(SearchTaskVO taskVO) {
		this.taskVO = taskVO;
	}
}