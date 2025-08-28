package com.zuppa_security.backend_Zuppa.controller;

import com.zuppa_security.backend_Zuppa.models.Users;
import com.zuppa_security.backend_Zuppa.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(value = "http://localhost:5173")
public class UserController {

    @Autowired
    UserService userser;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user){
        String res = userser.log(user);
        if(!res.equals("null")){
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UserName or Password Invalid!");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> del(@PathVariable String id){
        System.out.println(id);
        Boolean res = userser.delete(id);
        if(!res){
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("No user found");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete successfully");

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user){
         Boolean res = userser.reg(user);
         if(res){
             return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exist");
         }
         return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully...");
    }

    @GetMapping("/home")
    public ArrayList<Users> users(){
        return userser.getall();
    }


    @PutMapping("/update/{userName}")
    public ResponseEntity<?> update(@PathVariable String userName, @RequestBody Users user){
        Boolean res = userser.update(userName,user.getPassword());
        if(res){
            return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Existing User");
    }

}
