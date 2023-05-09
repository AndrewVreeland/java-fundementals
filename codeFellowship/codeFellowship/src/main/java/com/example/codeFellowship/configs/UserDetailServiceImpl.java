package com.example.codeFellowship.configs;

import com.example.codeFellowship.repos.SiteUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//TODO STEP 4A: CHEATSHEET #:create service implementation and required methods
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    SiteUserRepo siteUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) siteUserRepo.findByUsername(username);
    }
}
