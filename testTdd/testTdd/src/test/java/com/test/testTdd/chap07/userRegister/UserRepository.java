package com.test.testTdd.chap07.userRegister;

public interface UserRepository {

    void save(User user);
    User findById(String id);
}
