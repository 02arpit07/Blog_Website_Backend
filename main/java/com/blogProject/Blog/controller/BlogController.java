package com.blogProject.Blog.controller;
;
import com.blogProject.Blog.model.Blogs;
import com.blogProject.Blog.service.BlogService;
import com.blogProject.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @PostMapping("/addBlog")
    @ResponseBody
    public Blogs addBlog(@RequestBody Blogs blog, Principal principal) {
        return blogService.addBlog(blog, userService.getUserId(principal));
    }

    @GetMapping("/allBlogs")
    public List<Blogs> getAllBlogs() { return blogService.getBlogList(); }

    @GetMapping("/myBlogs")
    public List<Blogs> getMyBlogs(Principal principal) { return blogService.getMyBlogs(userService.getUserId(principal)); }

   @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id) {  return  blogService.deleteBlog(id); }

    @PostMapping("/editBlog")
    public Blogs editBlog(@RequestBody Blogs blog) { return blogService.editBlog(blog); }

    @GetMapping("/getBlog/{id}")
    public Blogs getBlog(@PathVariable int id) { return blogService.getBlog(id); }
    @GetMapping("/search/{searchedItem}")
    public Set<Blogs> searchItem(@PathVariable("searchedItem") String searchedItem) {
        Set<Blogs> blogs = blogService.getSearchedData(searchedItem);
        for (int i = 0; i < blogs.size(); i++) {
            System.out.println(blogs);
        }
        return blogs;
    }
    @GetMapping("/viewBlogs/{userId}")
    public List<Blogs> viewBlogs(@PathVariable int userId) { return blogService.toGet(userId); }

}
