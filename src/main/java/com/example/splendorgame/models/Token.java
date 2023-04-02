package com.example.splendorgame.models;

import lombok.Getter;

@Getter
public enum Token {

    RED,
    ORANGE,
    BLUE,
    BROWN,
    BLACK,
    GREEN,
    SILVER;

    public static Token fromValue(String sValue) throws IllegalArgumentException {
        for (Token value : Token.values()) {
            if(value.toString().equals(sValue))
                return value;
        }
        throw new IllegalArgumentException("Invalid Type of token passed");
    }
}
