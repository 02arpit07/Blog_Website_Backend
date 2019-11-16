package com.blogProject.Blog.service;

import com.blogProject.Blog.model.Follower;
import com.blogProject.Blog.model.Following;
import com.blogProject.Blog.model.Users;
import com.blogProject.Blog.repository.BlogRepository;
import com.blogProject.Blog.repository.FollowerRepository;
import com.blogProject.Blog.repository.FollowingRepository;
import com.blogProject.Blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AudienceService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FollowerRepository followerRepository;
    @Autowired
    FollowingRepository followingRepository;
    @Autowired
    BlogRepository blogRepository;


    public boolean checkFollowing(int currentUser, int userId) {
        Users current= userRepository.findByUserId(currentUser);
        Users follow = userRepository.findByUserId(userId);
     if(followingRepository.findAllByFollowingAndAndWorkingUser(follow,current)!=null)
     {
     return true;
     }
     else {
         return false;
     }
    }
    public void followThisUser(int currentUserId, int userId) {
        Users loggedInUser = userRepository.findByUserId(currentUserId);
        Users viewingUser = userRepository.findByUserId(userId);

        if(followingRepository.findAllByFollowingAndAndWorkingUser(viewingUser,loggedInUser) == null) {
            Following following = new Following(loggedInUser, viewingUser);
            followingRepository.save(following);
        }

        if(followerRepository.findAllByWorkingUserAndFollower(viewingUser, loggedInUser) == null) {
            Follower followers = new Follower(viewingUser, loggedInUser);
            followerRepository.save(followers);
        }

    }

    public void unfollowThisUser(int currentUser, int userId) {
        Users loggedInUser = userRepository.findByUserId(currentUser);
        Users viewingUser = userRepository.findByUserId(userId);

        if(followingRepository.findAllByFollowingAndAndWorkingUser(viewingUser,loggedInUser) != null) {
            Following following = (Following) followingRepository.findAllByFollowingAndAndWorkingUser( viewingUser,loggedInUser);
            System.out.println("done");
            followingRepository.delete(following);
            System.out.println("following");
        }

        if(followerRepository.findAllByWorkingUserAndFollower(loggedInUser,viewingUser) != null) {
            System.out.println("follower");
            Follower followers = (Follower) followerRepository.findAllByWorkingUserAndFollower(loggedInUser,viewingUser);
            followerRepository.delete(followers);
        }
    }

    public List<Follower> getFollowersOfThisAccount(int userId) {
        Users currentUser = userRepository.findByUserId(userId);
        System.out.println(followerRepository.findAllByWorkingUser(currentUser));
        return followerRepository.findAllByWorkingUser(currentUser);
    }

    public List<Following> getFollowingOfThisAccount(int userId) {
        Users currentUser = userRepository.findByUserId(userId);
        return followingRepository.findAllByWorkingUser(currentUser);
    }

}
