package com.testbeackenddeveloper.fikrizulfikarkusmana.controller;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.User;
import com.testbeackenddeveloper.fikrizulfikarkusmana.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Management System", tags = "User Management")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "View a list of all users", response = List.class)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Get user by ID", response = User.class)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "Create a new user", response = User.class)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
