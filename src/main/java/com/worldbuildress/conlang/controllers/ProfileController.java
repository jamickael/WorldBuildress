package com.worldbuildress.conlang.controllers;

import com.worldbuildress.conlang.Data.ProfileData;
import com.worldbuildress.conlang.models.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @GetMapping("/newProfile")
    public String displayNewProfileForm() {
        return "profile/newProfile";
    }

    @PostMapping("/newProfile")
    public String processNewProfileForm(Model model, @ModelAttribute Profile profile, String verify) {
        if (!verify.equals(profile.getPassword())) {
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("username", profile.getUsername());
            model.addAttribute("email", profile.getEmail());
            return "profile/newProfile"; //this reloads the profile creation page
        }
        ProfileData.add(profile);
        model.addAttribute("username", profile.getUsername());
        model.addAttribute("profiles", ProfileData.getAll());
        return "profile/userProfile"; //this should load you into your profile home page

    }

    @GetMapping("/existingProfile")
    public String displayExistingProfileForm() {
        return "profile/existingProfile";
    }

    @PostMapping("/existingProfile")
    public String processExistingProfileForm(Model model, @ModelAttribute Profile profile, String verify) {
        if (!verify.equals(profile.getPassword())) {
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("username", profile.getUsername());
            model.addAttribute("email", profile.getEmail());
            return "profile/existingProfile"; //this reloads the profile creation page
        }
        ProfileData.add(profile);
        model.addAttribute("username", profile.getUsername());
        model.addAttribute("profiles", ProfileData.getAll());
        return "profile/userProfile"; //this should load you into your profile home page
    }

    @GetMapping("/profileDetails/{id}")
    public String displayProfileDetails(@PathVariable int id, Model model) {
        model.addAttribute("profile", ProfileData.getById(id));
        return "profile/profileDetails";
    }

//    @PostMapping("profileDetails")
//    public String processProfileDetailEdits() {
//
//    }


}
