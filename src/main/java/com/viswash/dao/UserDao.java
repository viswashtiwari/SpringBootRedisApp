package com.viswash.dao;

import com.viswash.Entity.User;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Repository;

import java.util.Map;
@RequiredArgsConstructor
@Repository
public class UserDao {


    private final RedisTemplate<String,Object> redisTemplate;
    private static final String KEY="USERKEY";

    //SAVE USER
    public User save(User user){
        redisTemplate.opsForHash().put(KEY,user.getUserId(),user);
        return user;
    }

    //getUserBYId
    public User get(String userId){
        return (User)redisTemplate.opsForHash().get(KEY,userId);
    }

    //get All
    public Map<Object,Object> findAll(){
        return redisTemplate.opsForHash().entries(KEY);
    }

    //delete
    public void delete(String userId){
        redisTemplate.opsForHash().delete(KEY,userId);
    }
}
