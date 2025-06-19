package com.example.lottery.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottery.jfr.events.LotteryEvent;
import com.example.lottery.model.LotteryModel;
import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("/numbers")
//@RequestScope
@CrossOrigin
//@Validated
public class LotteryRestController {
	private static final AtomicInteger counter = new AtomicInteger(0); 	
	private final LotteryService lotteryService;

	public LotteryRestController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	// curl -X GET "http://localhost:3300/numbers?max=60&size=6"
	@GetMapping(params = { "max", "size" })
	public LotteryModel getLotteryNumbers(@RequestParam int max, @RequestParam int size) {
		System.err.println("New get request has been received: %d,%d".formatted(max,size));
		var begin = System.currentTimeMillis();
		var event = new LotteryEvent();
		event.begin();
		var lotteryNumbers = lotteryService.draw(max, size);
		event.count = counter.getAndIncrement();
		var end = System.currentTimeMillis();
		event.interval = end- begin;
		event.end();
		event.commit();		
		return lotteryNumbers;
	}
}
