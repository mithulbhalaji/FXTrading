package com.finzly.fxtrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtrading.entity.CurrencyPair;
import com.finzly.fxtrading.service.CurrencyPairService;

/*
 * CurrencyPair rest controller for interaction with currency pairs
 */

@RestController
@RequestMapping("currencypair")
public class CurrencyPairController {

	@Autowired
	CurrencyPairService currencyPairService;

	@GetMapping("getall")
	public ResponseEntity<Object> getAllCurrencyPair() {
		List<CurrencyPair> currencyPairs = currencyPairService.getAllCurrencyPair();
		if (currencyPairService.getAllCurrencyPair().isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(currencyPairs);
	}


}
