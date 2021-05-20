package com.globalLogic.logic.main.utils;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


public class View {

    public String getMessageWithStatistics(HashMap<Integer,StaticKeeper> statistics, int numberOfPatternLetters) {

        LinkedHashMap<Integer, StaticKeeper> statisticsSorted = getSortedStatistics(statistics);

        StringBuilder sb = new StringBuilder();
        sb.setLength(0);

        for (Map.Entry<Integer, StaticKeeper> entry : statisticsSorted.entrySet()){
            entry.getValue().getLettersOccurred().forEach((letter,num) ->
                    sb.append("Letter: ").append(letter).append(", ")
                            .append(" in word of length: ")
                            .append(entry.getKey())
                            .append(", Statistics: ")
                            .append(getFrequency(num, numberOfPatternLetters))
                            .append(", Letter/All letters indicator: ")
                            .append(num)
                            .append("/")
                            .append(numberOfPatternLetters)
                            .append("\n"));
            if (entry.getValue().getLettersOccurred().size() > 1){
                sb.append("Letters: ");
                entry.getValue().getLettersOccurred().forEach((letter,num) -> sb.append(letter).append(", "));
                sb.append(" in words of length: ")
                        .append(entry.getKey())
                        .append(", Statistics: ")
                        .append(getFrequency(entry.getValue().getOccurrence(), numberOfPatternLetters))
                        .append(", Letter/All letters indicator: ")
                        .append(entry.getValue().getOccurrence())
                        .append("/")
                        .append(numberOfPatternLetters)
                        .append("\n");}
        }
        return sb.toString();
    }

    private LinkedHashMap<Integer, StaticKeeper> getSortedStatistics(HashMap<Integer, StaticKeeper> statistics) {
        LinkedHashMap<Integer,StaticKeeper> statisticsSorted = statistics.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(StaticKeeper::getOccurrence)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return statisticsSorted;
    }

    private String getFrequency(int numberOccuredLetters, int numberOfPatternLetters){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(numberOccuredLetters / (double) numberOfPatternLetters);

    }
}
