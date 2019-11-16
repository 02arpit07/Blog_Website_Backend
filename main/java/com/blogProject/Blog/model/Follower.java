package com.blogProject.Blog.model;

import javax.persistence.*;

@Entity
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followerId;
    @ManyToOne
    private Users workingUser;
    @ManyToOne
    private Users follower;

    public Follower() {
    }

    public Follower(Users workingUser, Users follower) {
        this.workingUser = workingUser;
        this.follower = follower;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public Users getWorkingUser() {
        return workingUser;
    }

    public void setWorkingUser(Users workingUser) {
        this.workingUser = workingUser;
    }

    public Users getFollower() {
        return follower;
    }

    public void setFollower(Users follower) {
        this.follower = follower;
    }
}
