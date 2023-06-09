package com.example.codeFellowship.controllers;
import com.example.codeFellowship.repos.PostRepo;
import com.example.codeFellowship.models.Post;
import com.example.codeFellowship.models.SiteUser;
import com.example.codeFellowship.repos.SiteUserRepo;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;

// TODO: 2: CheatSheet 2: Create a user controller
@Controller
public class SiteUserController {
    @Autowired
    SiteUserRepo siteUserRepo;
    @Autowired
    PostRepo postRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/")
    public String getHomePage(Model m, Principal p) {
        if (p != null) {
            String username = p.getName();
            SiteUser user = siteUserRepo.findByUsername(username);

            m.addAttribute("username", username);
        }
        return "index.html";
    }

    @GetMapping("/login")
    public String getLoginPage(Principal p) {
        if (p != null) {
            return "redirect:/";
        }
        return "login.html";
    }

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup.html";
    }

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, LocalDate dateOfBirth, String bio, RedirectAttributes redir) {
        // Check if the username already exists
        if (siteUserRepo.findByUsername(username) != null) {
            redir.addFlashAttribute("errorMessage", "That username already exists!");
            return new RedirectView("/signup?error");
        }

        SiteUser newUser = new SiteUser(username, passwordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
        siteUserRepo.save(newUser);
        authWithHttpServletRequest(username, password);
        return new RedirectView("/");
    }

    public void authWithHttpServletRequest(String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            System.out.println("Error while logging in!");
            e.printStackTrace();
        }
    }

    @GetMapping("/test")
    public String getTestPage(Model m, Principal p) {
        if(p != null) {
            String username = p.getName();
            SiteUser user = siteUserRepo.findByUsername(username);

            if(user != null) {
                m.addAttribute("username", user.getUsername());
            }
        }

        return "test.html";
    }

    @GetMapping("/myprofile")
    public String getMyProfile(Model m, Principal p) {
        if(p != null) { //not strictly needed if WebSecurityConfig is set up properly
            SiteUser user = siteUserRepo.findByUsername(p.getName());
            m.addAttribute("user", user);
            m.addAttribute("username", user.getUsername());
            return "myprofile";
        }
        return "login";
    }

    @PutMapping("/myprofile")
    public RedirectView editProfile(Principal p, String username, String firstName, String lastName, LocalDate dateOfBirth, String bio, Long id, RedirectAttributes redir) {
        SiteUser user = siteUserRepo.findById(id).orElseThrow();
        if(p != null) { //not strictly needed if WebSecurityConfig is set up properly
            user.setUsername(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setDateOfBirth(dateOfBirth);
            user.setBio(bio);
            siteUserRepo.save(user);

            // include lines below if your principal is not updating
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(),
                    user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            redir.addFlashAttribute("errorMessage", "You are not permitted to edit this profile!");
        }

        return new RedirectView("/myprofile");
    }

    @PostMapping("/createPost")
    public RedirectView createPost(Principal p, String body,long id, RedirectAttributes redir) {
        SiteUser user = siteUserRepo.findById(id).orElseThrow();
        if(p != null) { //not strictly needed if WebSecurityConfig is set up properly
            Date date = new Date();
            Post post = new Post(body, date);
            user.addPost(post);
            postRepo.save(post);
            siteUserRepo.save(user);
        } else {
            redir.addFlashAttribute("errorMessage", "You are not permitted to add posts to this profile!");
        }
        return new RedirectView("/myprofile");
    }

    @GetMapping("/user/{id}")
    public String getUserInfoPage(Model m, Principal p, @PathVariable long id, RedirectAttributes redir) {
        if(p != null) {
            SiteUser user = siteUserRepo.findById(id).orElseThrow();
            m.addAttribute("user", user);

            SiteUser viewUser = siteUserRepo.findById(id).orElseThrow();

            m.addAttribute("viewUser", viewUser);
            m.addAttribute("usersIFollow", viewUser.getUsersIFollow());
            m.addAttribute("usersWhoFollowMe", viewUser.getUsersWhoFollowMe());
            return "profile";
        } else {
            redir.addFlashAttribute("errorMessage", "You must be logged in to view this profile!");
            return "redirect:/login";
        }
    }

    @PutMapping("follow-user/{id}")
    public RedirectView followUser(Principal p, @PathVariable Long id){
        SiteUser userTofollow = siteUserRepo.findById(id).orElseThrow(()-> new RuntimeException("Error reading user from database with id of: " + id));
        SiteUser currentAuthUser = siteUserRepo.findByUsername(p.getName());
        if(currentAuthUser.getUsername().equals(userTofollow.getUsername())){
            throw new IllegalArgumentException("you cannot follow yourself!");
        }
        currentAuthUser.getUsersIFollow().add(userTofollow);
        siteUserRepo.save(currentAuthUser);

        return new RedirectView("/user/" +id);

    }
}