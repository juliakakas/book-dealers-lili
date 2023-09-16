package hu.progmatic.springwebsite.service;

import hu.progmatic.springwebsite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    private final Random randomGenerator;

    @Autowired
    public UserService(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
        users.add(new User("Lajos Kalmár","Budapest",01123));
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public  User findUser(int id){
        User user = null;
        for(User actual : users){
            if (actual.getUserID() == id){
                user = actual;
            }
        }
        return user;
    }

    public User getRandomUser(){
        return  users.get(randomGenerator.nextInt(this.users.size()));
    }
}
