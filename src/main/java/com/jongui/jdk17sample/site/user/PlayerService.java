package com.jongui.jdk17sample.site.user;

import com.jongui.jdk17sample.persistence.PlayerEntity;
import com.jongui.jdk17sample.persistence.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    public PlayerEntity findById(Integer se) {
        return playerRepo.findById(se).orElseThrow(() -> new RuntimeException());
    }

    public List<PlayerEntity> findAll() {
        return playerRepo.findAll();
    }
}
