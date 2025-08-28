package com.zuppa_security.backend_Zuppa.repos;


import com.zuppa_security.backend_Zuppa.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Users,Integer> {
    Users findByuserName(String userName);
}
