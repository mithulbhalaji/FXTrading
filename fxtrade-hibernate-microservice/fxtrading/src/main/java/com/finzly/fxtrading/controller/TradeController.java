package com.finzly.fxtrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtrading.entity.Trade;
import com.finzly.fxtrading.service.TradeService;

/*
 * Trade rest controller for interaction with currency pairs
 */

@RestController
@RequestMapping("fxtrade")
public class TradeController {

	@Autowired
	TradeService tradeService;

	@GetMapping("showtrades")
	public ResponseEntity<Object> showtrades() {
		List<Trade> trades = tradeService.showTrades();
		if (tradeService.showTrades().isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(trades);
	}

	@PostMapping("booktrade")
	public ResponseEntity<Object> bookTrade(@RequestBody Trade trade) {
		String result = tradeService.bookTrade(trade);
		if(result==null) {
			return ResponseEntity.badRequest().body("Failed to book trade");
		}else {
			 return ResponseEntity.ok(result);
		}
	}

}
