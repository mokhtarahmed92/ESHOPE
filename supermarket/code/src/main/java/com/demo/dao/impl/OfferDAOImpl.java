package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.dao.OfferDAO;
import com.demo.model.Offer;

/**
 * OfferDAOImpl.java is a concrete implementation if the OfferDAO  
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */
@Repository("offerDao")
public class OfferDAOImpl extends AbstractDAO implements OfferDAO {

	/**
	 * addOffer is implementation to the add offer method
	 * @param Offer to be added
	 */
	public void addOffer(Offer offer) {
		persist(offer);
	}

	/**
	 * getAllOffers is implementation to get all offer method
	 * @return List of Offers
	 */
	@SuppressWarnings("unchecked")
	public List<Offer> getAllOffers() {
		Criteria criteria = getSession().createCriteria(Offer.class);
		return (List<Offer>) criteria.list();
	}

	/**
	 * findOffer is implementation to find an offer method
	 * @param integer of the offer id  
	 * @return Offer to be retrieved 
	 */
	public Offer findOffer(long id) {
		Criteria criteria = getSession().createCriteria(Offer.class);
		criteria.add(Restrictions.eq("id", id));
		return (Offer) criteria.uniqueResult();

	}

}
