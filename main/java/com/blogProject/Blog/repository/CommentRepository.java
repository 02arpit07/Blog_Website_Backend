package com.blogProject.Blog.repository;

import com.blogProject.Blog.model.Blogs;
import com.blogProject.Blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>
{
  List<Comment> findAllByBlog(Blogs blogs);
}
