package com.blogProject.Blog.repository;

import com.blogProject.Blog.model.Following;
import com.blogProject.Blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FollowingRepository extends JpaRepository<Following,Integer> {
    public Object findAllByFollowingAndAndWorkingUser(Users a, Users b);

    List<Following> findAllByWorkingUser(Users currentUser);
}
