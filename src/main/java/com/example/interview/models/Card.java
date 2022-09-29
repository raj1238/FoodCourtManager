package com.example.interview.models;

import lombok.Data;

import java.util.HashMap;

@Data
public class Card {

    private String cardId;
    private Token token;
    private HashMap<Token,Integer> purchaseCombination;

}
