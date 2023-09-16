package com.finzly.fxtrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.dao.CurrencyPairDao;
import com.finzly.fxtrading.entity.CurrencyPair;
import com.finzly.fxtrading.exception.DuplicateCurrencyPairException;
import com.finzly.fxtrading.exception.InvalidAmountException;
import com.finzly.fxtrading.exception.InvalidCurrencyPairException;

/*
 * CurrencyPairSerice is responsible for getting and adding the currency pair
 */

@Service
public class CurrencyPairService {

	@Autowired
	CurrencyPairDao currencyPairDao;

	public List<CurrencyPair> getAllCurrencyPair() {
		return currencyPairDao.getAllCurrencyPair();
	}


}
