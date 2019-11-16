package com.blogProject.Blog.service;

import com.blogProject.Blog.model.Users;
import com.blogProject.Blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserService {
    @Autowired
    UserRepository usersRepository;

    public Users addUser(Users user) { return usersRepository.save(user); }

    public int getUserId(Principal principal) {
        String email = principal.getName();
        return usersRepository.findByEmail(email).getUserId();
    }
    public Users callUser(Principal principal)
    {
        return usersRepository.findByEmail(principal.getName());
    }


    public Users changeUserDetails(Users users) {
        Users oldUser = usersRepository.findByUserId(users.getUserId());

        oldUser.setName(users.getName());
        oldUser.setEmail(users.getEmail());
        oldUser.setPassword(users.getPassword());
        oldUser.setPhoneNumber(users.getPhoneNumber());
        usersRepository.saveAndFlush(oldUser);
        return oldUser;
    }
    public Set<Users> findUser(String searchedItem, int id) {
        List<Users> usersList = usersRepository.findAll();
        Set<Users> result = new HashSet<>();
        Users currentUser = usersRepository.findByUserId(id);

        for(int i=0; i<usersList.size(); i++) {
            if(id != usersList.get(i).getUserId()) {
                if(usersList.get(i).getName().toLowerCase().contains(searchedItem.toLowerCase()) ||
                        usersList.get(i).getEmail().toLowerCase().contains(searchedItem.toLowerCase()) ) {
                    result.add(usersList.get(i));
                }
            }
        }
        return result;
    }
    public Users viewingUser(int id) {
        return usersRepository.findByUserId(id);
    }
}
