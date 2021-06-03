package com.spring.board.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home() {
        log.info("##### boardController");

        ModelAndView view = new ModelAndView();
        view.setViewName("index");

        return view;
    }
}