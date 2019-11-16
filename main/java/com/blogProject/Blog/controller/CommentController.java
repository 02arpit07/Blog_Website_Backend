package com.blogProject.Blog.controller;

import com.blogProject.Blog.model.Comment;
import com.blogProject.Blog.service.BlogService;
import com.blogProject.Blog.service.CommentService;
import com.blogProject.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @PostMapping("/addComment")
    @ResponseBody
    public Comment addComment(@RequestBody Comment comment, Principal principal) {
        return commentService.addComment(comment, userService.getUserId(principal));

    }


    @GetMapping("/allComments/{id}")
    public List<Comment> getAllComments(@PathVariable int id) { return commentService.getComments(id); }

}
