package com.demo.service;

import java.util.List;

import com.demo.model.Item;
/**
 * ItemService.java is a interface that define the skeleton of the ItemService implementation
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
public interface ItemService {

	/**
	 * addItem is definition to the add item method
	 * @param Item to be added
	 */
	void addItem(Item item);
	/**
	 * getAllItems is definition to get all items method
	 * @return List of Items
	 */
	List<Item> getAllItems();
	/**
	 * findItemById is definition to find an item method
	 * @param integer of the item id  
	 * @return items to be retrieved 
	 */
	Item findItemById(long id);

	/**
	 * findItemByName is definition to the find an item method
	 * @param String of the item name 
	 * @return item to be retrieved 
	 */
	Item findItemByName(String name);

	/**
	 * totalPriceforItems is definition to calculate the total price for n quantities of the same item
	 * @param integer the ordered pieces of the item 
	 * @param integer of the item id
	 * @return the total of price after the distcount 
	 */
	double totalPriceforItems(int quantity, long itemId);
	
}
