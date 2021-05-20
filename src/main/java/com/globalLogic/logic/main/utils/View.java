package com.globalLogic.logic.main.utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class View {

    public void display(String message){
        System.out.println(message);
    }

    public String getMessageWithStatistics(HashMap<Integer,StaticKeeper> statistics, int numberOfPatternLetters) {
//        List<Entry<Integer,StaticKeeper>> list = new LinkedList<Map.Entry<Integer,StaticKeeper>>(statistics.entrySet());
//        Collections.sort(list, new Comparator<Entry<Integer,StaticKeeper>>()) {
//            public int compare(Map.Entry<Integer,StaticKeeper> o1, Map.Entry<Integer,StaticKeeper> o2){
//                return (o1.getValue().getOccurence()).compareTo(o2.getValue().getOccurence());
//            }
//        });
//        LinkedHashMap<Integer,StaticKeeper> statisticsSorted = statistics.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));


        StringBuilder sb = new StringBuilder();
        sb.setLength(0);

        for (Map.Entry<Integer, StaticKeeper> entry : statistics.entrySet()){
            sb.setLength(0);
            entry.getValue().getLettersOccured().forEach((letter,num) ->
                    sb.append("Letter: ").append(letter).append(", ")
                            .append(" in words of length: ")
                            .append(entry.getKey())
                            .append(", Statistics: ")
                            .append(getFrequency(num, numberOfPatternLetters))
                            .append(", Letter/All letters indicator: ")
                            .append(num)
                            .append("/")
                            .append(numberOfPatternLetters)
                            .append("\n"));
            if (entry.getValue().getLettersOccured().size() > 1){
                sb.append("Letters: ");
                entry.getValue().getLettersOccured().forEach((letter,num) -> sb.append(letter).append(", "));
                sb.append(" in words of length: ")
                        .append(entry.getKey())
                        .append(", Statistics: ")
                        .append(getFrequency(entry.getValue().getOccurence(), numberOfPatternLetters))
                        .append(", Letter/All letters indicator: ")
                        .append(entry.getValue().getOccurence())
                        .append("/")
                        .append(numberOfPatternLetters)
                        .append("\n");}
        }
        return sb.toString();
    }

    private String getFrequency(int numberOccuredLetters, int numberOfPatternLetters){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(numberOccuredLetters / (double) numberOfPatternLetters);

    }
}
