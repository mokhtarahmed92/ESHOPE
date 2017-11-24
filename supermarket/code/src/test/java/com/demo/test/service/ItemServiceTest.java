package com.demo.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.configuration.SupermarketConfiguration;
import com.demo.model.Item;
import com.demo.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SupermarketConfiguration.class})
@Transactional
public class ItemServiceTest {

	@Autowired
	ItemService itemService;

	@Test
	public void addItemTest() {
		String itemName = "INFINX Note 2";
		Item item = new Item(150, itemName);
		itemService.addItem(item);
		Item item1 = itemService.findItemByName(itemName);
		Assert.assertTrue(item1.getName().equals(itemName));
	}

	@Test
	public void getAllItemsTest() {
		List<Item> items = itemService.getAllItems();
		Assert.assertTrue(items.isEmpty() == false);
	}

	@Test
	public void calculateTotalPrice() {
		double total = itemService.totalPriceforItems(7, 1);
		Assert.assertTrue(total == 5800);
	}

}
