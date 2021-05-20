package com.globalLogic.logic.main.utils;

import java.util.HashMap;

public class StaticKeeper {

    private int wordLength;
    private final HashMap<String,Integer> lettersOccured;
    private int occurence;

    public StaticKeeper(){
        this.lettersOccured = new HashMap<>();
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public HashMap<String, Integer> getLettersOccured() {
        return lettersOccured;
    }

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }
}
