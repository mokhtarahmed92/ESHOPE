package com.demo.dao;

import java.util.List;

import com.demo.model.Order;

/**
 * OrderDAO.java is a interface that define the skeleton of the OrderDAO implementation  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 * */
public interface OrderDAO {

	/**
	 * addOrder is definition to the add order method
	 * @param order to be added
	 */
	void addOrder(Order order);
	
	/**
	 * getAllOrders is definition to get all orders method
	 * @return List of orders
	 */
	List<Order> getAllOrders();
	
	/**
	 * findOrder is definition to find an order method
	 * @param integer of the order id  
	 * @return order to be retrieved 
	 */
	Order findOrder(long id);
	
}
