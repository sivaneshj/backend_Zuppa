package com.zuppa_security.backend_Zuppa.services;


import com.zuppa_security.backend_Zuppa.models.Users;
import com.zuppa_security.backend_Zuppa.repos.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    Repo repo;
    public Boolean reg(Users user){
        Users temp = repo.findByuserName(user.getUserName());
        if(temp == null){
            repo.save(user);
            return false;
        }
        return true;
    }

    public String log(Users user){
       Users temp =  repo.findByuserName(user.getUserName());
       if(temp != null){
           if(temp.getUserName().equals(user.getUserName()) && temp.getPassword().equals(user.getPassword())){
               return temp.getRole();
           }
       }
       return "null";
    }
    public ArrayList<Users> getall(){
        return new ArrayList<>(repo.findAll());
    }

    public Boolean delete(String id){
       Users res =  repo.findById(String.);
        System.out.println(res);
       if(res !=null){
           repo.delete(res);
           return true;
       }
       return false;
    }
}
