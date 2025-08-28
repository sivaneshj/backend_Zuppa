package com.zuppa_security.backend_Zuppa.services;

import com.zuppa_security.backend_Zuppa.models.Users;
import com.zuppa_security.backend_Zuppa.repos.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {
    @Autowired
    Repo repo;

    public ArrayList<Users> getall(){
        return new ArrayList<>(repo.findAll());
    }
}
