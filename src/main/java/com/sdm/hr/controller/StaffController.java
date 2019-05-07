package com.sdm.hr.controller;

import com.sdm.master.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/staff/")
    public String getStaff(Model model){

        model.addAttribute("data",userRepository.findAll());

        return "/User/index";
    }

    @GetMapping("/staff/add/")
    public String insertStaff(){
        return "/User/insert";
    }

}
