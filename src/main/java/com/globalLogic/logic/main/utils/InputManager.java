package com.globalLogic.logic.main.utils;

import com.globalLogic.logic.main.Input;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InputManager {

    private List<String> words;
    private String data;


    public List<String> getResult(){
        Input input = new Input("I love to work in global logic!");
        return input.getWordsWithoutSpecialCharacters();

    }


    public void add(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
