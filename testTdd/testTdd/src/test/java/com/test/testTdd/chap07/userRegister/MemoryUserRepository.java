package com.test.testTdd.chap07.userRegister;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


public class MemoryUserRepository implements UserRepository {

    Map<String, User> map = new HashMap<>();

    @Override
    public void save(User user) {
        map.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return map.get(id);
    }
}
