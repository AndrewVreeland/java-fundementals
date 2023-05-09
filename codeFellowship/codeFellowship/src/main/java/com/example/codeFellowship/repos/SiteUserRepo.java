package com.example.codeFellowship.repos;

import com.example.codeFellowship.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO: Step 1B: CheatSheet 1: create user repo
public interface SiteUserRepo extends JpaRepository<SiteUser, Long> {

    //TODO STEP4B create a findbyusername() method in order to help get user details
    public SiteUser findByUsername(String username);

    //TODO
}
