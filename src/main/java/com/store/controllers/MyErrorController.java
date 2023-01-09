package com.store.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyErrorController implements ErrorController {
    @GetMapping("/error")
    public ModelAndView handleError(HttpServletResponse response){
        return new ModelAndView("error","status",response.getStatus());
    }
}
