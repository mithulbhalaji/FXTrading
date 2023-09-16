package com.finzly.fxtrading.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.dao.CurrencyPairDao;
import com.finzly.fxtrading.dao.TradeDao;
import com.finzly.fxtrading.entity.Trade;
import com.finzly.fxtrading.exception.CurrencyPairNotFoundException;
import com.finzly.fxtrading.exception.InvalidAmountException;
import com.finzly.fxtrading.exception.InvalidCustomerNameException;

/*
 * TransactionService class is responsible for checking the input and books the trade 
 */

@Service
public class TradeService {

	@Autowired
	private TradeDao tradeDao;

	@Autowired
	private CurrencyPairDao currencyPairDao;

	private static final DecimalFormat DECIMALFORMAT = new DecimalFormat("###,###,###,###.00");

	public List<Trade> showTrades() {
		return tradeDao.showTrades();
	}

	public String bookTrade(Trade trade) {
		try {
			if (!isValidName(trade.getCustomerName())) {

				throw new InvalidCustomerNameException(trade.getCustomerName());
			}

			if (trade.getAmount() <= 0) {
				throw new InvalidAmountException(trade.getAmount());
			}
			String currencyPairInTransaction = trade.getCurrencyPair();
			double rate = currencyPairDao.getRate(currencyPairInTransaction);
			if (rate != -1) {
				trade.setRate(rate);
				trade.setConvertedAmount(convertAmount(rate, trade.getAmount()));
				if (tradeDao.bookTrade(trade)) {
					return stringDisplayFormat(currencyPairInTransaction, rate, trade.getConvertedAmount(),
							trade.getCustomerName());
				}
			} else {
				throw new CurrencyPairNotFoundException(currencyPairInTransaction);
			}
			return null;
		} catch (InvalidCustomerNameException | InvalidAmountException | CurrencyPairNotFoundException e) {
			return e.getMessage();
		}

	}

	// For converting amount
	public double convertAmount(double amount, double rate) {
		return amount * rate;
	}

	// Using regex for name validation
	public boolean isValidName(String name) {
		return name.matches("^(?!\\.+$)[A-Za-z. ]+$") ? true : false;
	}

	// To display the message in the required format
	private String stringDisplayFormat(String currencyPair, double rate, double convertedAmount, String customerName) {
		return "Trade for " + currencyPair + " " + "has been booked with rate " + DECIMALFORMAT.format(rate)
				+ " , The amount of " + currencyPair.substring(3, 6).toUpperCase() + " "
				+ DECIMALFORMAT.format(convertedAmount) + " will be transferred in 2 working days to " + customerName
				+ ".";
	}

}
