package com.cts.tm.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(ignoreResourceNotFound=true, value="classpath:customMsg.properties")
public class CustomPropertyVO {
	
	@Value("${success}")
	public String success;
	
	@Value("${failure}")
	public String failure;
	
	@Value("${task.creation.successfull}")
	public String taskCreationSuccessfull;
	
	@Value("${task.creation.fail}")
	public String taskCreationFail;
	
	@Value("${error}")
	public String error;
	
	@Value("${notFound}")
	public String notFound;
	
	@Value("${task.search.not.found}")
	public String noResultFound;
	
	@Value("${task.deleted.successful}")
	public String taskDeletedSuccess;
	
	@Value("${task.deleted.fail}")
	public String taskDeletionFailed;

	@Value("${task.not.found}")
	public String taskNotFound;
	
	@Value("${task.updation.success}")
	public String taskUpdateSuccess;
	
	@Value("${task.updation.fail}")
	public String taskUpdateFail;
}