package com.globalLogic.logic.controller;

import com.globalLogic.logic.main.model.InputDTO;
import com.globalLogic.logic.main.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AppController {
    private final FrequencyService service;

    @Autowired
    public AppController(FrequencyService service){
        this.service = service;
    }

    @GetMapping(value = "/")
    public String getIndexPage(Model model){
        model.addAttribute("action", "GET RESULT");
        InputDTO inputDTO = new InputDTO();
            InputDTO resultDTO = new InputDTO();
            if (service.getInput() != null && service.getInput().getInput() != null){
                String statistics = service.getStatistics();
                resultDTO.setData(statistics);
            }
        model.addAttribute("inputDTO", inputDTO);
        model.addAttribute("resultDTO", resultDTO);

        return "index";
    }
    @PostMapping(value = "/input", consumes = MediaType.ALL_VALUE)
    public String getStatistics(@Valid InputDTO inputDTO){
        service.add(inputDTO);
        return "redirect:/";

    }


}