package com.jongui.jdk17sample.admin;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

public interface AdminLoginService {
    Set<SimpleGrantedAuthority> login(String nickname, String pw);
}
