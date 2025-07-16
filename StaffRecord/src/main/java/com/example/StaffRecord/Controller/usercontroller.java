package com.example.StaffRecord.Controller;

import com.example.StaffRecord.model.users;
import com.example.StaffRecord.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class usercontroller {
    private final UserService userService;

    private usercontroller(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("users", new users());
        return "add";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute users user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        userService.getUserById(id).ifPresentOrElse(
                user -> model.addAttribute("users", user),
                () -> model.addAttribute("users", new users())
        );
        return "edit";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute users updatedUser) {
        userService.getUserById(id).ifPresent(user -> {
            user.setId(updatedUser.getId());
            user.setStaffname(updatedUser.getStaffname());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            userService.saveUser(user);
        });
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
