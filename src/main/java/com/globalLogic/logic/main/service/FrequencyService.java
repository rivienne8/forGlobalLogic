package com.globalLogic.logic.main.service;

import com.globalLogic.logic.main.InputDTO;
import com.globalLogic.logic.main.utils.FrequencyManager;
import com.globalLogic.logic.main.utils.InputManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrequencyService {

    private final InputManager manager;
    private final FrequencyManager frequencyManager;

    @Autowired
    public FrequencyService(InputManager manager, FrequencyManager frequencyManager) {
        this.manager = manager;
        this.frequencyManager = frequencyManager;
    }

    public void add(InputDTO inputDTO){
        manager.add(inputDTO.getData());
        return;
    }

    public String getResult(){
        return manager.getData();
    }
}
