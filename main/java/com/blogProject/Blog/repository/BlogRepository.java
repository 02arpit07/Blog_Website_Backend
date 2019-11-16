package com.blogProject.Blog.repository;

import com.blogProject.Blog.model.Blogs;
import com.blogProject.Blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blogs, Integer> {

    List<Blogs> findAllByUserId(Users user);
    Blogs findById(int id);
}
