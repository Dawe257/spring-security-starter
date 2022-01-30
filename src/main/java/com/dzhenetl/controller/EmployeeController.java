package com.dzhenetl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public String getInfoForAllEmps() {
        return "all-employees-view";
    }

    @GetMapping("/hr_info")
    public String getInfoOnlyForHR() {
        return "hr_view";
    }

    @GetMapping("/manager_info")
    public String getInfoOnlyForManagers() {
        return "managers_view";
    }

}
