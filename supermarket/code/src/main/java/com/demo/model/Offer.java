package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Offer.java is a pojo to represent the item object in the db 
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
@Entity
@Table(name="OFFER")
public class Offer implements Comparable<Offer> {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long Id;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="COUNT")
	private int count;


    
	public Offer() {
		super();
	}

	public Offer(double price, int count) {
		super();
		this.price = price;
		this.count = count;
	}

	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		result = prime * result + count;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Offer other = (Offer) obj;
		if (Id != other.Id)
			return false;
		if (count != other.count)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [Id=" + Id + ", price=" + price + ", count=" + count + "]";
	}

	public int compareTo(Offer o) {
		
		return (int)(o.getCount() - this.getCount());
	}
	
	
}
