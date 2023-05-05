package com.example.Hash.repos;

import com.example.Hash.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
     public SiteUser getSiteUserByUserName(String userName);
}