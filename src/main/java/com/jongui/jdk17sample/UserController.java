package com.jongui.jdk17sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @Autowired
    private CustomExcelView excelView;

    @GetMapping("/excel")
    public ModelAndView getExcel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(excelView);
        return modelAndView;
    }

}
