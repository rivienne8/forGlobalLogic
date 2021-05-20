package com.globalLogic.logic.main.utils;

import com.globalLogic.logic.main.model.Input;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class InputManager {

    private List<String> words;
    private Input input;
    private List<String> patternChars;

    private final View view;

//    example input: "I love to work in global logic!"


    public InputManager(){
        this.view = new View();
    }

    public void getPattern(){
        String input = "Logic";
        this.patternChars = new ArrayList<>(Arrays.asList(input.toLowerCase().split("")));
    }

    public void setWordsFromInput(){
        String regex = "[^a-zA-Z ]";
        this.words = input.getWordsWithoutSpecialCharacters(regex);
    }

    public List<String> getInputCharacters(){
        List<String> letters =  new ArrayList<>(Arrays.asList(
                input.retriveInputWithoutSpecialsCharsAndWhitespaces()
                        .split("")));
        return letters;
    }

    public String getStatistics(HashMap<Integer, StaticKeeper> statistics, int numberOfPatternLetters){
        return view.getMessageWithStatistics(statistics, numberOfPatternLetters);
    }

    public List<String> getPatternChars() {
        return patternChars;
    }

    public void add(String data) {
        this.input = new Input(data);
    }
    public Input getInput() {
        return input;
    }

    public List<String> getWords() {
        return words;
    }
}
