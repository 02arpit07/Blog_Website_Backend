package com.blogProject.Blog.repository;

import com.blogProject.Blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(String email);

    Users findByUserId(int userId);
}
