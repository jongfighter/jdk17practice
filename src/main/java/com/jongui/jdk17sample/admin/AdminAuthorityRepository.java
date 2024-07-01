package com.jongui.jdk17sample.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAuthorityRepository extends JpaRepository<AdminAuthorityEntity, Integer> {
}
