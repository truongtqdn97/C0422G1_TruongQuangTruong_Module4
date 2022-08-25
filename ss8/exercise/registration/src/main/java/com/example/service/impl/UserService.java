package com.example.service.impl;

import com.example.model.User;
import com.example.repository.IUserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        this.iUserRepository.save(user);
    }

    @Override
    public Page<User> findAllUser(Pageable pageable) {
        return this.iUserRepository.findAll(pageable);
    }
}
