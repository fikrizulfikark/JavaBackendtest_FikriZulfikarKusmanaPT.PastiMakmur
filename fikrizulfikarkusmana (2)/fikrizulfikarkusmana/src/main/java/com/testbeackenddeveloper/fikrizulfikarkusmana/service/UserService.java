package com.testbeackenddeveloper.fikrizulfikarkusmana.service;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.User;
import com.testbeackenddeveloper.fikrizulfikarkusmana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        kafkaProducerService.sendUserMessage("Created User with ID: " + savedUser.getId() + " and name: " + savedUser.getName());
        return savedUser;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
