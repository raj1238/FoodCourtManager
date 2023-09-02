package com.example.splendorgame;

import com.example.splendorgame.models.Card;
import com.example.splendorgame.models.Player;
import com.example.splendorgame.models.Token;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;


@SpringBootApplication
public class SplendorGameApplication {

	public static void main(String[] args) {

		SplendorGameManager splendorGameManager = new SplendorGameManager();

		Player player = new Player();
		player.setName("Raj");
		HashMap<Token,Integer> tokensAvailable = new HashMap<>();
		tokensAvailable.put(Token.RED,5);
		tokensAvailable.put(Token.GREEN,5);
		tokensAvailable.put(Token.BLACK,5);
		tokensAvailable.put(Token.SILVER,5);
		player.setAvailableTokens(tokensAvailable);

		Card card = new Card();
		card.setCardId("cId1");
		card.setToken(Token.RED);
		HashMap<Token,Integer> purchaseCombination = new HashMap<>();
		purchaseCombination.put(Token.RED,3);
		purchaseCombination.put(Token.GREEN,4);
		purchaseCombination.put(Token.SILVER,1);
		card.setPurchaseCombination(purchaseCombination);

		Card card2 = new Card();
		card2.setToken(Token.GREEN);
		card2.setCardId("cId2");
		HashMap<Token,Integer> purchaseCombination2 = new HashMap<>();
		purchaseCombination2.put(Token.RED,2);
		purchaseCombination2.put(Token.GREEN,1);
		purchaseCombination2.put(Token.BLUE,6);
		card2.setPurchaseCombination(purchaseCombination2);

		Card card3 = new Card();
		card3.setToken(Token.BLUE);
		card3.setCardId("cId3");
		HashMap<Token,Integer> purchaseCombination3 = new HashMap<>();
		purchaseCombination3.put(Token.RED,2);
		purchaseCombination3.put(Token.GREEN,1);
		purchaseCombination3.put(Token.BLACK,4);
		card3.setPurchaseCombination(purchaseCombination3);

		boolean cardPurchasableByPlayer = splendorGameManager.isCardPurchasableByPlayer(player, card);
		System.out.println("Card with id : " + card.getCardId() + " is purchasable ? " + cardPurchasableByPlayer);

		System.out.println();

		System.out.println(splendorGameManager.purchaseCard(player,card));
		System.out.println(splendorGameManager.purchaseCard(player,card2));
		System.out.println(splendorGameManager.purchaseCard(player,card3));

		for (Token token : player.getAvailableTokens().keySet())
			System.out.println(token.toString() + " : " + player.getAvailableTokens().get(token));

		for (Token t : player.getPurchasedCards().keySet())
			System.out.println("Purchased for token : " + t.toString() + " " + player.getPurchasedCards().get(t));
	}

}
