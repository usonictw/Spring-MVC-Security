package service;


import pojo.User;

public interface UserService {

    void save(User user);
    User findByUserName(String userName);
}
