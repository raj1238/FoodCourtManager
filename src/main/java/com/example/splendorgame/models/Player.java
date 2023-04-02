package com.example.splendorgame.models;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class Player {

    private String name;
    private HashMap<Token, Integer> availableTokens = new HashMap<>();
    private HashMap<Token, List<Card>> purchasedCards = new HashMap<>();

}
