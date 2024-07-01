package com.jongui.jdk17sample.site.user;

import com.jongui.jdk17sample.persistence.UserLogEntity;
import com.jongui.jdk17sample.persistence.UserLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLogService {
    @Autowired
    private UserLogRepo userLogRepo;

    public Page<UserLogEntity> findAll(Pageable pageable) {
        return userLogRepo.findAll(pageable);
    }

    public List<UserLogEntity> findAll() {
        return userLogRepo.findAll();
    }

    public Optional<UserLogEntity> findById(Integer seq) {
        return userLogRepo.findById(seq);
    }
}
