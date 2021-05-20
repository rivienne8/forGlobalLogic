package com.globalLogic.logic.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private final String input;
    private String inputWithoutSpecialChars;

    public Input(String input){
        this.input = input.toLowerCase();
    }

    public List<String> getWordsWithoutSpecialCharacters(String regex){
        setInputWithoutSpecialChar(regex);
        return new ArrayList<>(Arrays.asList(this.inputWithoutSpecialChars.split(" ")));
    }

    private void setInputWithoutSpecialChar(String regex){
        this.inputWithoutSpecialChars = this.input.replaceAll(regex,"");
    }

    public String retriveInputWithoutSpecialsCharsAndWhitespaces(){
        return inputWithoutSpecialChars.replaceAll(" ", "");
    }

    public String getInput() {
        return input;
    }
}
