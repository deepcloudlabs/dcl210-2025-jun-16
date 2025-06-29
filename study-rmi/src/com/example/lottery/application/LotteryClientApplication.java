package com.example.lottery.application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.example.lottery.service.LotteryService;

public class LotteryClientApplication {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		LotteryService lotteryService = (LotteryService) Naming.lookup("rmi://localhost:8800/lottery/LotteryService");
		for (int i = 0; i < 100; ++i) {
			System.out.println(lotteryService.draw(60, 6).getNumbers());
		}
	}

}
