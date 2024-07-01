package com.jongui.jdk17sample.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<PlayerEntity, Integer> {
}
