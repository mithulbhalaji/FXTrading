package com.finzly.fxtrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtrading.entity.Trade;

/*
 * TradeDao class is responsible for interaction with trade table in database 
 */

@Repository
public class TradeDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<Trade> showTrades() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Trade.class);
		return criteria.list();
	}

	public boolean bookTrade(Trade trade) {
		Session session = sessionFactory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
		return true;
	}

}
