package com.jongui.jdk17sample.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminUserRepository extends JpaRepository<AdminUserEntity, Integer> {

    Optional<AdminUserEntity> findByNicknameAndIsDeletedFalse(String nickname);
}
