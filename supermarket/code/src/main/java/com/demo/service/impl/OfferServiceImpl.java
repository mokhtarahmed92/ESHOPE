package com.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.dao.OfferDAO;
import com.demo.model.Offer;
import com.demo.service.OfferService;

/**
 * OfferServiceImpl.java is a concrete implementation if the OfferService  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
@Service("offerService")
@Transactional
public class OfferServiceImpl implements OfferService{

	@Autowired
	private OfferDAO offerDao;
	
	
	/**
	 * addOffer is definition to the add offer method
	 * @param Offer to be added
	 */
	public void addOffer(Offer Offer) {
		offerDao.addOffer(Offer);
		
	}
	/**
	 * getAllOffers is definition to get all offer method
	 * @return List of Offers
	 */
	public List<Offer> getAllOffers() {
		return offerDao.getAllOffers();
	}
	/**
	 * findOffer is definition to find an offer method
	 * @param integer of the offer id  
	 * @return Offer to be retrieved 
	 */
	public Offer findOffer(long id) {
		return offerDao.findOffer(id);
	}

}
