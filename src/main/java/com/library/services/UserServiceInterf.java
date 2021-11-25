package com.library.services;

import com.library.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInterf {
    public void save(User user);
}
