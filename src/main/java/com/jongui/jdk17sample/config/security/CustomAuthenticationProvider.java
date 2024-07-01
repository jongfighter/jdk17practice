package com.jongui.jdk17sample.config.security;

import com.jongui.jdk17sample.admin.AdminLoginService;
import com.jongui.jdk17sample.admin.AdminUserAuthorityEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component(value = "CustomAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final AdminLoginService userLoginService;


    public CustomAuthenticationProvider(AdminLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = (String) authentication.getPrincipal();
        String pw = (String) authentication.getCredentials();
        Set<SimpleGrantedAuthority> authorities = userLoginService.login(id, pw);
        return new UsernamePasswordAuthenticationToken(id, pw, authorities);
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
