package com.employeecontrolpanal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "MyLoginPage";
    }

    @GetMapping("/access_denied")
    public String showAccessDeniedPage() {
        return "access_denied";
    }
}
