package com.hcl.coronathreat;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CoronalistImpl implements CoronaListRepository {
	    private SessionFactory sessionFactory;
	    @Autowired 
	    public CoronalistImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	
	    @Override
	    public CoronalistEntity findById(int id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        TypedQuery<CoronalistEntity> query = session.getNamedQuery("findAccountById");  
	        query.setParameter("id", id);
	        CoronalistEntity account = query.getSingleResult();
	        return account;
	    }
	    @Override
	    public CoronalistEntity findByStateAndCity(String state,String city) {
	        Session session = this.sessionFactory.getCurrentSession();
	        TypedQuery<CoronalistEntity> query = session.getNamedQuery("findbyStateAndCity");  
	        query.setParameter("state", state);
	        query.setParameter("city", city);
	        CoronalistEntity entity = query.getSingleResult();
			return entity;
	    }
	    @Override
	    public List<CoronalistEntity> findByState(String state) {
	        Session session = this.sessionFactory.getCurrentSession();
	        TypedQuery<CoronalistEntity> query = session.getNamedQuery("findbyState");  
	        query.setParameter("state", state);
	        List<CoronalistEntity> entity = query.getResultList();
			return entity;
	    }
	   
	
}
