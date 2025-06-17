package com.viswash.controller;

import com.viswash.Entity.User;
import com.viswash.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping
    public User createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
       return userDao.save(user);

    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return userDao.get(userId);
    }
   //findAll
    @GetMapping
    public Map<Object,Object> getAll(){
        return userDao.findAll();
    }
    //delete User
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        userDao.delete(userId);
    }
}
