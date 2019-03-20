package com.cts.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.Session;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cts.tm.model.Task;
import com.cts.tm.repository.ITaskCustomRepository;
import com.cts.tm.vo.SearchTaskVO;
@Repository
public class TaskCustomRepositoryImpl implements ITaskCustomRepository{

/*	@PersistenceContext private EntityManager em;
	
	SessionFactory sf;
	
	//@Autowired HibernateTemplate hibernateTemplete;
	
	  @Autowired
	    private EntityManager entityManager;
	
	
	@SuppressWarnings({ "deprecation" })
	@Override
	public List<Task> getSearchResults(SearchTaskVO searchVO)throws Exception{
		
		*/
		
		/*Criteria crit = sf.getCurrentSession().createCriteria(Task.class);
		List<Task> results = crit.list();
		*/
		
	/*	
		Criteria dcr = sf.getCurrentSession().createCriteria(Task.class);
		
		 
		
        if(searchVO.getTask()!=null)
        	dcr.add(Restrictions.eq("task", searchVO.getTask()));
        if(searchVO.getParentTask()!=null)
        	dcr.add(Restrictions.eq("parentTask.parentTask", searchVO.getParentTask()));
		if(searchVO.getPriorityStart() != null)
			dcr.add(Restrictions.ge("priority", searchVO.getPriorityStart()));
		else
			dcr.add(Restrictions.ge("priority", 0));
		if(searchVO.getPriorityTo() != null)
			dcr.add(Restrictions.le("priority", searchVO.getPriorityTo()));
		else
			dcr.add(Restrictions.le("priority", 100));
		if(searchVO.getStartDate() != null)
			dcr.add(Restrictions.le("start_date", searchVO.getStartDate()));
		if(searchVO.getEndDate() != null)
			dcr.add(Restrictions.le("end_date", searchVO.getEndDate()));
        
		
		List<Task> students = dcr.list();
		
		return students;
	};
	
	*/
	
	
}
