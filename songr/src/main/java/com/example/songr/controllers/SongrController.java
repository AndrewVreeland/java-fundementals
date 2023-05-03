package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repository.albumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongrController {
    //TODO: 6. wire our repository to our controller
@Autowired
albumRepository albumRepository;

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello";
    }
    @GetMapping("/")
    public String splashPage() {
        return "/splashPage";
    }
    

    @GetMapping("/capitalize/{newText}")
    public String capitalize(Model model, @PathVariable String newText) {
        model.addAttribute("capitalizedText", newText.toUpperCase());
        return "capitalize";
    }



    @GetMapping("/albums")
    public String albums(Model model) {
        Album[] albums = {
                new Album("Faces", "Scary Kids Scaring Kids", 13, 1499, "/images/640x640.jpg"),
                new Album("Home Sick", "A Day To Remember", 11, 1534, "/images/aDayToRemember.jpg"),
                new Album("WE ARE TRIUMPHANT COUNT YOUR BLESSINGS.", "Bring Me The Horizon", 10, 1800, "/images/countYourBlessings.jpg")
        };

        model.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/")
    public RedirectView createAlbum(String title, String artist, Integer songCount, Integer lengthInSeconds, String imageUrl){
        Album newAlbum = new Album(title, artist, songCount, lengthInSeconds, imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/");
    }

}
