package com.blogProject.Blog.controller;

import com.blogProject.Blog.model.Follower;
import com.blogProject.Blog.model.Following;
import com.blogProject.Blog.service.AudienceService;
import com.blogProject.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AudienceController {

    @Autowired
    AudienceService audienceService;
    @Autowired
    UserService userService;

    @GetMapping("/IsFollowing/{id}")
    public String isFollowing(@PathVariable int id, Principal principal)
    {
        if(audienceService.checkFollowing(userService.getUserId(principal), id)){
            System.out.println("True");
            return "\"true\"";
        } else {
            System.out.println("False");
            return "\"false\"";
        }
    }
    @GetMapping("/followUser/{userId}")
    public String followUser(@PathVariable int userId, Principal principal)
    {
        audienceService.followThisUser(userService.getUserId(principal), userId);
        return "\"Followed\"";
    }

    @GetMapping("/uncollated/{userId}")
    public String unfollowUser(@PathVariable int userId, Principal principal)
    {
        audienceService.unfollowThisUser(userService.getUserId(principal), userId);
        return "\"unFollowed\"";
    }

    @GetMapping("/getFollowers")
    public List<Follower> getFollowers(Principal principal)
    {
        return audienceService.getFollowersOfThisAccount(userService.getUserId(principal));
    }

    @GetMapping("/getFollowings")
    public List<Following> getFollowings(Principal principal)
    {
        return audienceService.getFollowingOfThisAccount(userService.getUserId(principal));
    }

}
