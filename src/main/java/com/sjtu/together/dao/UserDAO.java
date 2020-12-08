package com.sjtu.together.dao;

import com.sjtu.together.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User findByUserid(int userID);

    User getByUsernameAndPassword(String username,String password);
}
