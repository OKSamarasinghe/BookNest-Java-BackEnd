package com.example.user.Controller;

import com.example.user.Service.UserService;
import com.example.user.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public List<User>getAllUser(){
        return userService.getAllUsers();
    }
    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user){
        return userService.createUsers(user);
    }
    @GetMapping(path = "/users/{id}")
    public User getOrderById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUser(id);
    }
    @PutMapping(path = "/users/{id}")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping(path = "/users", params = "name")
    public List<User> findUserByName(@RequestParam String name){
        return userService.findUserByName(name);
    }
    @GetMapping("/users/username/{username}")
    public boolean checkUsernameExistence(@PathVariable String username) {
        return userService.getAllUsernames().contains(username);
    }

    /*@GetMapping(path = "/users/username/{username}")
    public List<String>getAllUsernames(){
        return userService.getAllUsernames();
    }*/

}
