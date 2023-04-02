package com.example.splendorgame;

import com.example.splendorgame.models.Card;
import com.example.splendorgame.models.Player;
import com.example.splendorgame.models.Token;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;

@Service
public class SplendorGameManager {

    public boolean isCardPurchasableByPlayer(Player player, Card card) {

        HashMap<Token,Integer> tokensNeeded = card.getPurchaseCombination();
        HashMap<Token,Integer> tokensAvailable = player.getAvailableTokens();

        for (Token token : tokensNeeded.keySet()) {

            Integer tokensNeed = tokensNeeded.get(token);
            Integer tokensPresent = nullSafeInt(tokensAvailable.get(token));
            Integer cardsAvailable= 0;
            if(player.getPurchasedCards().get(token)!=null) {
                cardsAvailable = nullSafeInt(player.getPurchasedCards().get(token).size());
            }

            if(tokensNeed > tokensPresent + cardsAvailable)
                return false;

        }

        return true;
    }

    private Integer nullSafeInt(Integer integer) {
        if(integer==null)
            return Integer.valueOf(0);
        return integer;
    }

    public boolean purchaseCard(Player player, Card card) {

        if(isCardPurchasableByPlayer(player,card)){
            HashMap<Token,Integer> tokensNeeded = card.getPurchaseCombination();
            HashMap<Token,Integer> tokensAvailable = player.getAvailableTokens();
            for (Token token : tokensNeeded.keySet()) {
                Integer tokensNeed = tokensNeeded.get(token);
                Integer tokensPresent = nullSafeInt(tokensAvailable.get(token));
                Integer cardsAvailable = 0;
                if (player.getPurchasedCards().get(token) != null) {
                    cardsAvailable = nullSafeInt(player.getPurchasedCards().get(token).size());
                }

                Integer tokensToBeUsed = tokensNeed - cardsAvailable;
                if(tokensToBeUsed<0)
                    tokensToBeUsed = 0;

                tokensAvailable.put(token,tokensPresent-tokensToBeUsed);

            }
            addToPurchasedCards(player, card);
            return true;
        }
        else
            return false;
    }

    private void addToPurchasedCards(Player player, Card card) {
        if(player.getPurchasedCards().get((card.getToken()))==null)
            player.getPurchasedCards().put(card.getToken(), Arrays.asList(card));
        else
            player.getPurchasedCards().get(card.getToken()).add(card);
    }

}
