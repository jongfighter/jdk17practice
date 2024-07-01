package com.jongui.jdk17sample.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "site/dashboard";
    }
}
