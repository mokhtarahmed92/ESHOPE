package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.dao.ItemDAO;
import com.demo.model.Item;

/**
 * ItemDAOImpl.java is a concrete implementation if the ItemDAO  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
@Repository("itemDao")
public class ItemDAOImpl extends AbstractDAO implements ItemDAO {

	/**
	 * addItem is implementation to the add item method
	 * @param Item to be added
	 */
	public void addItem(Item item) {
		persist(item);
	}
	/**
	 * getAllItems is implementation to get all items method
	 * @return List of Items
	 */
	@SuppressWarnings("unchecked")
	public List<Item> getAllItems() {
		Criteria criteria = getSession().createCriteria(Item.class);
		return (List<Item>) criteria.list();
	}

	/**
	 * findItemById is implementation to find an item method
	 * @param integer of the item id  
	 * @return items to be retrieved 
	 */
	public Item findItemById(long id) {
		Criteria criteria = getSession().createCriteria(Item.class);
		criteria.add(Restrictions.eq("id", id));
		return (Item) criteria.uniqueResult();

	}

	/**
	 * findItemByName is implementation to the find an item method
	 * @param String of the item name 
	 * @return items to be retrieved 
	 */
	@Override
	public Item findItemByName(String name) {
		Criteria criteria = getSession().createCriteria(Item.class);
		criteria.add(Restrictions.eq("name", name));
		return (Item) criteria.uniqueResult();
	}

}
