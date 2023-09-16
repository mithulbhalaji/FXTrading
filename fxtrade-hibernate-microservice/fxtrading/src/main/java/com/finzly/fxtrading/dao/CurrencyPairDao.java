package com.finzly.fxtrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtrading.entity.CurrencyPair;

/*
 * CurrencyPairDao class is responsible for interaction with currency pair table in database  
 */

@Repository
public class CurrencyPairDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<CurrencyPair> getAllCurrencyPair() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		return criteria.list();

	}

	public String addCurrencyPair(CurrencyPair currencyPair) {
		Session session = sessionFactory.openSession();
		session.save(currencyPair);
		session.beginTransaction().commit();
		return "Currency Pair added";
	}

	public double getRate(String currencyPairInTransaction) {
		Session session = sessionFactory.openSession();
		CurrencyPair currencyPair = session.get(CurrencyPair.class, currencyPairInTransaction);
		if (currencyPair == null) {
			return -1;
		}
		return currencyPair.getRate();
	}
	


}
