package com.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Order.java is a pojo to represent the item object in the db 
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
@Entity
@Table(name="ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long Id;
	
	@Column(name="DESCRIPTION")
	private String description;
	

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "ORDER_ITEMS", 
        joinColumns = { @JoinColumn(name = "ORDER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "ITEM_ID") }
    )
    Set<Item> items = new HashSet<Item>();


	public Order(String description) {
		super();
		this.description = description;
	}


	public Order() {
		super();
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Item> getItems() {
		return items;
	}


	public void setItems(Set<Item> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Order [Id=" + Id + ", description=" + description + ", items=" + items + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (Id != other.Id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
    
    
}
