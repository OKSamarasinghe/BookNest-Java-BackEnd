package com.example.user.Service;

import com.example.user.data.User;
import com.example.user.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    public User createUsers(User user){
        return userRepository.save(user);
    }
    public User getUserById(int id){
        Optional<User>user=userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }

    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public List<String> getAllUsernames() {
        return userRepository.findAll().stream().map(User::getUsername).collect(Collectors.toList());
    }

}
