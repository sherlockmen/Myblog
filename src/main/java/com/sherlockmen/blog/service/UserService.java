package com.sherlockmen.blog.service;

import com.sherlockmen.blog.po.User;

public interface UserService {

    User checkUser(String blogUsername, String blogPassword);


}
