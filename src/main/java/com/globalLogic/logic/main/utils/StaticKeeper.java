package com.globalLogic.logic.main.utils;

import java.util.HashMap;

public class StaticKeeper {

    private int wordLength;

    private final HashMap<String,Integer> lettersOccurred;
    private int occurrence;

    public StaticKeeper(){
        this.lettersOccurred = new HashMap<>();
    }


    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public HashMap<String, Integer> getLettersOccurred() {
        return lettersOccurred;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }
}
