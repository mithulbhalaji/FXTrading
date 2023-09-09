package com.fxtrade.fxtradingmicroservice.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fxtrade.fxtradingmicroservice.model.Transaction;

@Service
public class FXtradeService {

		//Initializing required fields
		public List<Transaction> transactions = new ArrayList<>();
		private int count=1;
		private double rate = 66.0;
		private final DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.00");
		
		public boolean getTrade() {
			return transactions.isEmpty() ? true : false;
		}
		
		public String bookTrade(Transaction transaction) {
			
			transaction.setTradeno(count);
			if(isValidAmount(transaction.getAmount())){
				return "Not valid amount";
			}else if(!transaction.getCurrencyPair().equalsIgnoreCase("usdinr")) {
				return "Not a valid currency pair";
			}else if(isValidName(transaction.getCustomerName())) {
				return "Not a valid customer name";
			}else {
				transaction.setRate(rate);
				transaction.setAmount(transaction.getAmount()*rate);
				transactions.add(transaction);
				count++;
				return stringDisplayFormat(transaction.getCurrencyPair(), transaction.getRate(),
						transaction.getAmount(), transaction.getCustomerName());
		 	}
		}
		
	    //To print the data in required format
	  	private  String stringDisplayFormat(String currencyPair,double rate,
	  			double convertedAmount,String customerName) {
	  			return "Trade for "+currencyPair+" " +
	  	                "has been booked with rate "+decimalFormat.format(rate)+
	  	                " , The amount of "+currencyPair.substring(3,6).toUpperCase() +" "+
	  	                decimalFormat.format(convertedAmount)+
	  	                " will be transferred in 2 working days to "+customerName+".";
	  		}
	  		
	  	//Checking the amount
	  	private  boolean isValidAmount(double amount) {
	  			return amount<=0 ? true:false;
	  		}
	  		
	  	//Checking the name
	  	private  boolean isValidName(String name) {
	  			return name.matches("^(?!\\.+$)[A-Za-z. ]+$") ? false: true;
	  		}
	
}
