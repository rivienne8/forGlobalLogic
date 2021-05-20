package com.globalLogic.logic.controller;

import com.globalLogic.logic.main.InputDTO;
import com.globalLogic.logic.main.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    private final FrequencyService service;

    @Autowired
    public AppController(FrequencyService service){
        this.service = service;
    }

    @GetMapping(value = "/")
    public String getIndexPage(Model model){
//        model.addAttribute("words", manaserger.getResult());
        model.addAttribute("action", "GET RESULT");
        InputDTO inputDTO = new InputDTO();
//        if (service.getResult() != null) {
            InputDTO resultDTO = new InputDTO();
            resultDTO.setData(service.getResult());
//        }
        model.addAttribute("inputDTO", inputDTO);
        model.addAttribute("resultDTO", resultDTO);

        return "index";
    }
    @PostMapping(value = "/input")
    public String getStatistics(InputDTO inputDTO){
        service.add(inputDTO);
        return "redirect:/";

    }


}