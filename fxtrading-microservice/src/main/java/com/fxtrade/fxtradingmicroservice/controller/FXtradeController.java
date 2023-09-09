package com.fxtrade.fxtradingmicroservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxtrade.fxtradingmicroservice.model.Transaction;
import com.fxtrade.fxtradingmicroservice.service.FXtradeService;

@RestController
@RequestMapping("fxtrade")
public class FXtradeController {
	
	@Autowired
	FXtradeService fXtradeService;
	
	@GetMapping("showtrades")
	private ResponseEntity<Object> getTrades(){
		if(fXtradeService.getTrade()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(fXtradeService.transactions,HttpStatus.FOUND);
	}
	
	@PostMapping("booktrade")
	private String bookTrade(@RequestBody Transaction transaction) {
		return fXtradeService.bookTrade(transaction);
	}
	

	@GetMapping("/exit")
    private void exit() {
        System.exit(0);
    }
}
