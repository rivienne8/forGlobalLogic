package com.globalLogic.logic.main.utils;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


public class FrequencyManager {
    private List<String> patternCharacters;
    private List<String> wordsCharacters;
    private List<String> words;
    private int numberOfAllWords;
    private int numberOfAllChars;
    private Map<String,Integer> frequencyMap;



    public FrequencyManager(List<String> characters, List<String> words, List<String> wordsCharacters) {
        this.patternCharacters = characters;
        this.words = words;
        this.wordsCharacters = wordsCharacters;
        setNumberOfAllChars();
        setNumberOfAllWords();
        frequencyMap = new HashMap<>();
    }

    private void setNumberOfAllChars() {
        this.numberOfAllChars = this.words.stream()
                .map(String::length)
                .reduce(0, Integer::sum);
    }

    public void setNumberOfAllWords() {
        this.numberOfAllWords = words.size();
    }

    public int getNumberOfPatternLettersInInput(){
        return (int) this.wordsCharacters
                .stream()
                .filter(letter -> patternCharacters.contains(letter))
                .count();
    }

    public String getOverallPatternFrequency(){
        int numberOfPatternLettersInInput = getNumberOfPatternLettersInInput();
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(numberOfPatternLettersInInput / (double) numberOfAllChars);
    }

    public HashMap<Integer, StaticKeeper> getStatistics(){

        List<String> sortedWords = this.words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        HashMap<Integer, StaticKeeper> statistics = new HashMap<>();

        for (String word : sortedWords){
            if (patternCharacters.stream().anyMatch(word::contains)){
                StaticKeeper keeper;
                if (!statistics.containsKey(word.length())){
                    keeper = new StaticKeeper();
                    keeper.setWordLength(word.length());
                    updateKeeper(word, keeper);
                    statistics.put(word.length(),keeper);
                } else {
                    keeper = statistics.get(word.length());
                    updateKeeper(word, keeper);
                }
            }
        }
        return statistics;
    }

    private void updateKeeper(String word, StaticKeeper keeper) {
        List<String> letters = getMatchedLetters(word);
        for (String letter : letters){
            if (!keeper.getLettersOccured().containsKey(letter)){
                keeper.getLettersOccured().put(letter, 1);
            } else {
                keeper.getLettersOccured().put(letter, keeper.getLettersOccured().get(letter) +1 );
            }
            keeper.setOccurence(keeper.getOccurence()+1);
        }
    }

    private List<String> getMatchedLetters(String word) {
        return Arrays.stream(word.split(""))
                .filter(letter -> this.patternCharacters.contains(letter))
                .collect(Collectors.toList());
    }

}
