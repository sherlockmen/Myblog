package com.sherlockmen.blog.service;

import com.sherlockmen.blog.dao.UserRepository;
import com.sherlockmen.blog.po.User;
import com.sherlockmen.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User checkUser(String blogUsername, String blogPassword) {

        User user = userRepository.findByBlogUsernameAndBlogPassword(blogUsername, MD5Util.code(blogPassword));

        return user;
    }
}
