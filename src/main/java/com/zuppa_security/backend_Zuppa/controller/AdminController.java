package com.zuppa_security.backend_Zuppa.controller;

import com.zuppa_security.backend_Zuppa.models.Users;
import com.zuppa_security.backend_Zuppa.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@CrossOrigin(value = "http://localhost:5173")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminservive;
    @GetMapping("/home")
    public ArrayList<Users> users(){
        return adminservive.getall();
    }
}
