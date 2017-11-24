package com.demo.service;

import java.util.List;

import com.demo.model.Item;
import com.demo.model.Order;


/**
 * OrderService.java is a interface that define the skeleton of the OrderService implementation  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 * */
public interface OrderService {

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
	
	/**
	 * calculateTotalPrice is definition to calculate the total cart price
	 * @param List of items  
	 * @return total price of the items in the cart 
	 */
	double calculateTotalPrice(List<Item> items);
	
}
