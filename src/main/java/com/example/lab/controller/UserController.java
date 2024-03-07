package com.example.lab.controller;

import com.example.lab.model.User;
import com.example.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //displays home page
    @GetMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "index";
    }

    //displays add user page
    @GetMapping("/display-add-form")
    public String displayAddUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    //adds user and redirects to home page
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    //displays user detail of specific id
    @GetMapping("/view-user/{id}")
    public String viewUser(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "view-user";
    }

    //displays update user page
    @GetMapping("/display-update-form/{id}")
    public String displayUpdateForm(@PathVariable("id") long id, Model model) {

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    //updates user and redirect to home page
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user, Model model, BindingResult result) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }
        userService.updateUser(user);
        model.addAttribute("listUsers", userService.getAllUsers());
        return "redirect:/";
    }

    //deletes user of specific id
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.deleteUser(id);
        return "redirect:/";
    }

    //searches for a keyword and return matching list of users
    @GetMapping("/search")
    public String searchUser(@RequestParam("query") String query, Model model) {
        List<User> searchResults = userService.searchUser(query);
        model.addAttribute("listUsers", searchResults);
        return "index";
    }
}
