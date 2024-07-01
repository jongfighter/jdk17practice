package com.jongui.jdk17sample.site.user;

import com.jongui.jdk17sample.persistence.PlayerLogEntity;
import com.jongui.jdk17sample.persistence.PlayerLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerLogService {
    @Autowired
    public PlayerLogRepo playerLogRepo;

    public List<PlayerLogEntity> getAll() {
        return playerLogRepo.findAll();
    }

}
