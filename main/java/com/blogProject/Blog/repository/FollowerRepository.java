package com.blogProject.Blog.repository;

import com.blogProject.Blog.model.Follower;
import com.blogProject.Blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends JpaRepository<Follower,Integer> {
    Object findAllByWorkingUserAndFollower(Users currentUser, Users follower);

    List<Follower> findAllByWorkingUser(Users currentUser);

}
