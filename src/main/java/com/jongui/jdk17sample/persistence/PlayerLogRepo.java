package com.jongui.jdk17sample.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerLogRepo extends JpaRepository<PlayerLogEntity, Integer> {
}
