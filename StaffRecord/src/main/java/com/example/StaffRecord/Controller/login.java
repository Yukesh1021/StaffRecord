package com.example.StaffRecord.Controller;

import com.example.StaffRecord.model.page;
import com.example.StaffRecord.Repository.pageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/page")
public class login {
    private final pageRepository pageRepo;

    public login(pageRepository pageRepository) {
        this.pageRepo = pageRepository;
    }

    @GetMapping
    public String listpage(Model model) {
        model.addAttribute("page", pageRepo.findAll());
        return "listpage";
    }
    @GetMapping("/login")
    public String showloginform(Model model) {
        model.addAttribute("page", new page());
        return "Loginpage";
    }
    @PostMapping("/success")
    public String savesuccesspage(Model model) {
        model.addAttribute("page", new page());
        return "success";
    }
    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("page", new page());
        return "redirect:/page";
    }
}