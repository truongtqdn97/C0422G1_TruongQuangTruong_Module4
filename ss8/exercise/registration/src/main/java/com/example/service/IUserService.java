package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    void save(User user);

    Page<User> findAllUser(Pageable pageable);
}
