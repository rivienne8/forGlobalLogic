package com.globalLogic.logic.main.service;

import com.globalLogic.logic.main.model.Input;
import com.globalLogic.logic.main.model.InputDTO;
import com.globalLogic.logic.main.utils.FrequencyManager;
import com.globalLogic.logic.main.utils.InputManager;
import com.globalLogic.logic.main.utils.StaticKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FrequencyService {

    private final InputManager manager;

    @Autowired
    public FrequencyService(InputManager manager) {
        this.manager = manager;
    }

    public void add(InputDTO inputDTO){
        manager.add(inputDTO.getData());
    }

    public Input getInput(){
        return manager.getInput();
    }

    public String getStatistics() {
        manager.getPattern();
        manager.setWordsFromInput();

        FrequencyManager frequencyManager = new FrequencyManager(manager.getPatternChars(),
                manager.getWords(),
                manager.getInputCharacters());

        HashMap<Integer, StaticKeeper> detailedStatistics = frequencyManager.getStatistics();
        String result = manager.getStatistics(detailedStatistics, frequencyManager.getNumberOfPatternLettersInInput());
        String totalResult = frequencyManager.getOverallPatternFrequency();

        return totalResult !=null && totalResult.length()>0 ? result + "\n\nTOTAL FREQUENCY: " + totalResult : result;
    }
}
