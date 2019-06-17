package com.biz.blackjack.controller;

import com.biz.blackjack.service.BlackjackService;

public class Blackjack_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackService bs = new BlackjackService();
		
		bs.makeDeck();
		
		bs.viewCardList();
	}

}
