package com.example.codeFellowship.repos;

import com.example.codeFellowship.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SiteUserRepo extends JpaRepository<SiteUser, Long> {
    public SiteUser findByUsername(String username);
}
