package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Item;
import com.demo.service.ItemService;

/**
 * ItemsRestController.java is a rest api that 
 * handle the items requests like list all items, get item or calculate total price for n items  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 * */
@RestController
public class ItemsRestController {

	@Autowired
	ItemService itemService;

	/**
	 * getAllItems is a rest api that returns all the available items in the store
	 * @return List of all items in the supermarket 
	 * */
	@RequestMapping("/items")
	public List<Item> getAllItems() {
		List<Item> items = itemService.getAllItems();
		return items;
	}
	
	/**
	 * getItem is a rest api that return an item from the store with specific id 
	 * @param id  integer to represent the item id
	 * @return Item   that represent the item in the store
	 * */
	@RequestMapping("/items/{id}")
	public Item getItem(@PathVariable long id) {
		return itemService.findItemById(id);
	}
	/**
	 * calculatePrice is a rest api that calculate the total price for n pieces of specific item
	 * @param quantity  an integer to represent how many pieces of this items 
	 * @param id an integer to represent the the id of the item
	 * @return total price for all pieces  
	 * */
	@RequestMapping("/calcPrice")
	public double calculatePrice(@RequestParam(required = false, value = "qnty")int quantity,
								 @RequestParam(required = false, value = "id")long id) {
		return itemService.totalPriceforItems(quantity, id);
	}
	
}
