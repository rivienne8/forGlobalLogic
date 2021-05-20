package com.globalLogic.logic.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private String input;
    private String regex = "/[^a-zA-Z ]/g";

    public Input(String input){
        this.input = input;
    }

    public List<String> getWordsWithoutSpecialCharacters(){
        this.input = this.input.replace("[^a-zA-Z ]"," ");
        System.out.println(this.input);
        return new ArrayList<>(Arrays.asList(input.split(" ")));
    }




}
