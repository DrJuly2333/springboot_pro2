package com.example.pro2.service;

import com.example.pro2.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity getById(int id);

    UserEntity add(UserEntity user);

    void update(UserEntity user);

    void deleteById(Integer id);
}
