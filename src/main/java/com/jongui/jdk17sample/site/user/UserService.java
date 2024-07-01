package com.jongui.jdk17sample.site.user;

import com.jongui.jdk17sample.persistence.UserEntity;
import com.jongui.jdk17sample.persistence.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity findById(Integer id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }
}
