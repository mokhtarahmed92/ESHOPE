package com.demo.service.impl;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.ItemDAO;
import com.demo.model.Item;
import com.demo.model.Offer;
import com.demo.service.ItemService;

/**
 * ItemServiceImpl.java is a concrete implementation if the ItemService  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDAO itemDao;
	
	/**
	 * addItem is definition to the add item method
	 * @param Item to be added
	 */
	public void addItem(Item Item) {
		itemDao.addItem(Item);
		
	}
	/**
	 * getAllItems is definition to get all items method
	 * @return List of Items
	 */
	public List<Item> getAllItems() {
		return itemDao.getAllItems();
	}

	/**
	 * findItemById is definition to find an item method
	 * @param integer of the item id  
	 * @return items to be retrieved 
	 */
	public Item findItemById(long id) {
		return itemDao.findItemById(id);
	}
	
	/**
	 * findItemByName is definition to the find an item method
	 * @param String of the item name 
	 * @return item to be retrieved 
	 */
	@Override
	public Item findItemByName(String name) {
		return itemDao.findItemByName(name);
	}

	/**
	 * totalPriceforItems is definition to calculate the total price for n quantities of the same item
	 * The logic of this function  is very simple 
	 * i assumed that the same product may have many offers for example 
	 * if i bought 7 pieces of iphone7 which price is 1000$
	 * and it had a two offers 1800 for 2 pieces and  3000$ for 4 pieces so the total prices after 
	 * discounting both offers 1800(2)+3000(4)+1000(1) = 5800$  
	 * @param integer the ordered pieces of the item 
	 * @param integer of the item id
	 * @return the total of price after the distcount 
	 */
	public double totalPriceforItems(int quantity, long itemId){
		Item item = findItemById(itemId);
		int tempQuantity = quantity;
		double totalPrice = 0;
		
		if(item.getOffers().size() > 0){
			Offer[] offers = item.getOffers().toArray(new Offer[item.getOffers().size()]);
			Arrays.sort(offers);
			for(Offer offer: offers){
				if(offer.getCount() < tempQuantity){
					tempQuantity -= offer.getCount();
					totalPrice += offer.getPrice();
				}
			}
		}
		
		if(tempQuantity >= 1)
			totalPrice += tempQuantity * item.getPrice();
		
		return totalPrice;
	}
}
