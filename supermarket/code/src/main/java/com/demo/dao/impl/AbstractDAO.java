package com.demo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AbstractDAO.java is a interface that define some common methods between all doas
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
public abstract class AbstractDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * getSession is method to get the current session
	 * @return session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * persist is method to add object to the db 
	 * @param object to be added
	 */
	public void persist(Object entity) {
		getSession().persist(entity);
	}

	/**
	 * delete is method to get delete object from the db
	 * @param object to be deleted
	 */
	public void delete(Object entity) {
		getSession().delete(entity);
	}
}
