package com.example.springmvcdemo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springmvcdemo.model.User;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();

    public UserService(List<User> userList) {
        this.userList.add(new User("1", "Bill", 23));
    }

    public User getUserById(String id) {
        for (int i = 0; i < this.userList.size(); i++) {
            // == tests for reference equality
            // equals tests for value equality
            if (this.userList.get(i).getId().equals(id)) {
                return this.userList.get(i);
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        for (int i = 0; i < this.userList.size(); i++) {
            if(this.userList.get(i).getName().toLowerCase()
                    .equals(name.toLowerCase())) {

                return this.userList.get(i);
            }
        }
        return null;
    }

}
