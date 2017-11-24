package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.dao.OrderDAO;
import com.demo.model.Order;

/**
 * OrderDAOImpl.java is a concrete implementation if the OrderDAO  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
@Repository("orderDao")
public class OrderDAOImpl extends AbstractDAO implements OrderDAO {

	/**
	 * addOrder is implementation to the add order method
	 * @param order to be added
	 */
	public void addOrder(Order order) {
		persist(order);
	}

	/**
	 * getAllOrders is implementation to get all orders method
	 * @return List of orders
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		Criteria criteria = getSession().createCriteria(Order.class);
		return (List<Order>) criteria.list();
	}

	/**
	 * findOrder is implementation to find an order method
	 * @param integer of the order id  
	 * @return order to be retrieved 
	 */
	public Order findOrder(long id) {
		Criteria criteria = getSession().createCriteria(Order.class);
		criteria.add(Restrictions.eq("id", id));
		return (Order) criteria.uniqueResult();

	}

}
