package com.biz.blackjack.controller;

import java.util.Scanner;

import com.biz.blackjack.service.BlackjackService;
import com.biz.blackjack.service.PlayService;

public class Blackjack_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		BlackjackService bs = new BlackjackService();
		bs.makeDeck();

		while (true) {
			System.out.println("--------------------------------");
			System.out.println("Game Start");
			System.out.println("--------------------------------");

			PlayService dealer = new PlayService(bs.getDeck(), "딜러");
			PlayService player = new PlayService(bs.getDeck(), "플레이어");

			for (int i = 0; i < 2; i++) {
				dealer.hit();
				player.hit();
			}
			while (true) {
				System.out.println("-------------------------------");
				System.out.println("1.Hit      2.Stand      0.GameEnd");
				System.out.println("-------------------------------");
				System.out.println("선택 >");
				String strMenu = scan.nextLine();

				try {
					int intMenu = Integer.valueOf(strMenu);
					if (intMenu == 0) {
						System.out.println("Goodbye");
						return;
						// main method에서 return 문을 마나면
						// 프로젝트 실행이 종료
					}
					if (intMenu == 1) {
						dealer.hit();
						player.hit();
					}
					int dSum = dealer.sumValue();
					int pSum = player.sumValue();

					if (pSum > 21) {
						System.out.println("딜러승리");
						break;
					}else if (dSum > 21) {
						System.out.println("플레이어 승리");
						break;
					}
					
					if(intMenu == 2) {
						if(dSum > pSum) {
							System.out.println("딜러승리");
						}else {
							System.out.println("플레이어 승리");
						}
						System.out.println("아무키나 누르세요...");
						break;
					}
					
				} catch (Exception e) {

				}

			}

		}

	}

}
