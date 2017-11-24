package com.demo.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.configuration.AppConfig;
import com.demo.service.OfferService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class OrderServiceTest {

	@Autowired
	OfferService offerService;

	@Test
	public void addOfferTest() {

	}

	@Test
	public void getAllOffersTest() {
	
	}


}
