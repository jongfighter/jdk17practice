package com.jongui.jdk17sample.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLogRepo extends JpaRepository<UserLogEntity, Integer> {

    Optional<UserLogEntity> findBySeq(Integer seq);
}
