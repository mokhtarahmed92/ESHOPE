package com.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.OrderDAO;
import com.demo.model.Item;
import com.demo.model.Order;
import com.demo.service.OrderService;

/**
 * OrderServiceImpl.java is a concrete implementation if the OrderService  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDao;
	
	/**
	 * addOrder is definition to the add order method
	 * @param order to be added
	 */
	public void addOrder(Order Order) {
		orderDao.addOrder(Order);
		
	}

	/**
	 * getAllOrders is definition to get all orders method
	 * @return List of orders
	 */
	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	/**
	 * findOrder is definition to find an order method
	 * @param integer of the order id  
	 * @return order to be retrieved 
	 */
	public Order findOrder(long id) {
		return orderDao.findOrder(id);
	}

	/**
	 * calculateTotalPrice is definition to calculate the total cart price
	 * @param List of items  
	 * @return total price of the items in the cart 
	 */
	public double calculateTotalPrice(List<Item> items) {
		return 0;
	}



}
