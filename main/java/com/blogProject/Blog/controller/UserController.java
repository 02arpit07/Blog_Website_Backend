package com.blogProject.Blog.controller;

import com.blogProject.Blog.model.Users;
import com.blogProject.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController
{
    @Autowired
    UserService userService;


    @GetMapping(path = "/validateLogin", produces = "application/json")
    public String validateLogin()
    {
        return "\"checked\"";
    }

    @PostMapping(value = "/addUsers")
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @GetMapping("/callUser")
    public Users callUsers(Principal principal)
    {
        return userService.callUser(principal);
    }

    @PostMapping("/editUser")
    public Users editUsers(@RequestBody Users user)
    {
        return userService.changeUserDetails(user);
    }
    @GetMapping("/searchUser/{searchedItem}")
    public Set<Users> searchUser(@PathVariable("searchedItem") String searchedItem, Principal principal)
    {
        Set<Users> users = userService.findUser(searchedItem, userService.getUserId(principal));
        return users;
    }
    @GetMapping("/viewUser/{id}")
    public Users viewUser(@PathVariable int id)
    {
        return userService.viewingUser(id);
    }
}
