package com.demo.dao;

import java.util.List;

import com.demo.model.Offer;

/**
 * OfferDAO.java is a interface that define the skeleton of the OfferDAO implementation  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 * */
public interface OfferDAO {

	/**
	 * addOffer is definition to the add offer method
	 * @param Offer to be added
	 */
	void addOffer(Offer offer);
	
	/**
	 * getAllOffers is definition to get all offer method
	 * @return List of Offers
	 */
	List<Offer> getAllOffers();
	
	/**
	 * findOffer is definition to find an offer method
	 * @param integer of the offer id  
	 * @return Offer to be retrieved 
	 */
	Offer findOffer(long id);
	
}
