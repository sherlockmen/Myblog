package com.sherlockmen.blog.dao;

import com.sherlockmen.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByBlogUsernameAndBlogPassword(String username, String password);

}
