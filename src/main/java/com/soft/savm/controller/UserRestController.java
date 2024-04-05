/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package com.soft.savm.controller;

import com.soft.savm.dao.user.InvalidArguemntsException;
import com.soft.savm.dao.user.UserDAO;
import com.soft.savm.entity.UserEntity;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PMYLS
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserDAO userDao;

    public UserRestController(UserDAO userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/addUser")
    public UserEntity addUser(@RequestBody UserEntity user) throws InvalidArguemntsException {
//        if(user.getUserName() ==  null || user.getUserName() == ""){
//            throw new RuntimeException("Name cannot be null");
//        }
        UserEntity userEntity = userDao.addUser(user);
        return userEntity;
    }

    @GetMapping("getUserById/{userId}")
    public UserEntity getUserById(@PathVariable int userId) {
        return userDao.getUserById(userId);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public UserEntity deleteUser(@PathVariable int userId) {
        return userDao.deleteUser(userId);

    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();

    }

}
