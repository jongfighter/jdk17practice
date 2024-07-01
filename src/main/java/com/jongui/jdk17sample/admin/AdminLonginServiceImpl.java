package com.jongui.jdk17sample.admin;

import jakarta.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminLonginServiceImpl implements AdminLoginService {

    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;


    public AdminLonginServiceImpl(AdminUserRepository adminUserRepository, PasswordEncoder passwordEncoder) {
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Set<SimpleGrantedAuthority> login(String nickname, String pw) {
        AdminUserEntity adminUserEntity = adminUserRepository.findByNicknameAndIsDeletedFalse(nickname).orElseThrow(() -> new NoSuchElementException("No such user"));
        if (!passwordEncoder.matches(pw, adminUserEntity.getPassword())) {
            throw new IllegalArgumentException("Password is not correct");
        }
        Set<AdminUserAuthorityEntity> a = adminUserEntity.getAdminUserAuthorityEntities();

        Set<SimpleGrantedAuthority> authorities =
                a.stream()
                        .filter(s -> !s.getAuthority().getIsDeleted())
                        .map(k -> new SimpleGrantedAuthority(k.getAuthority().getAuthorityName()))
                        .collect(Collectors.toSet());
        return authorities;
    }
}
