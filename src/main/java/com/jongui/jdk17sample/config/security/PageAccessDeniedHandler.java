package com.jongui.jdk17sample.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;

import java.io.IOException;

/**
 * 인증은 되었으나, 인가가 안된 경우
 */
@Slf4j
public class PageAccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.sendRedirect("/access-denied");
    }
}
