package com.example.codeFellowship.controllers;

import com.example.codeFellowship.models.SiteUser;
import com.example.codeFellowship.repos.SiteUserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

// TODO: 2: CheatSheet 2: Create a user controller
@Controller
public class SiteUserController {
    @Autowired
    SiteUserRepo siteUserRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/")
    public String getHomePage(Model m, Principal p){
        if (p != null) {
            String username = p.getName();
            SiteUser user = siteUserRepo.findByUsername(username);
m.addAttribute("username", username);
        }


        return "index.html";
    }

    //TODO: Step3: CheatSheet 7, part1, Make a dummy login page
    @GetMapping("/login")
    public String getLoginPage(){
        return "/login.html";
    }

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio){
        SiteUser newUser = new SiteUser();
        newUser.setFirstName(firstName);
        newUser.setUsername(username);
        newUser.setLastName(lastName);
        newUser.setBio(bio);
        newUser.setDateOfBirth(dateOfBirth);
        String encryptedPassword = passwordEncoder.encode(password);
        newUser.setPassword(encryptedPassword);


        siteUserRepo.save(newUser);
        authWithHttpServletRequest(username, password);

return new RedirectView("/");
    }

    public void authWithHttpServletRequest(String username, String password){
        try{
            request.login(username, password);
        }catch (ServletException e){
            System.out.println("Error while logging in!");
            e.printStackTrace();
        }
    }

}
