package com.blogProject.Blog.service;

import com.blogProject.Blog.model.Blogs;
import com.blogProject.Blog.model.Comment;
import com.blogProject.Blog.model.Users;
import com.blogProject.Blog.repository.BlogRepository;
import com.blogProject.Blog.repository.CommentRepository;
import com.blogProject.Blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment, int userId) {
        Users currentUser = userRepository.findByUserId(userId);
        comment.setUser(currentUser);
        return commentRepository.save(comment);

    }
    public List<Comment> getComments(int id) {
        Blogs blogs=blogRepository.findById(id);
        return commentRepository.findAllByBlog(blogs);
    }
}
