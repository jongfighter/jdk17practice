package com.jongui.jdk17sample.site;

import com.jongui.jdk17sample.admin.AdminUserEntity;
import com.jongui.jdk17sample.admin.AdminUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@Slf4j
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminUserRepository adminUserRepository;

    @GetMapping("/create")
    public void createUser(@RequestParam String nickname, @RequestParam String password) {
        AdminUserEntity adminUserEntity = new AdminUserEntity();
        adminUserEntity.setName("이름" + UUID.randomUUID().toString().substring(0, 10));
        adminUserEntity.setNickname(nickname);
        adminUserEntity.setPassword(passwordEncoder.encode(password));
        adminUserEntity.setIsDeleted(false);
        adminUserRepository.save(adminUserEntity);

    }

    @GetMapping("/login")
    public String login() {
        String test = passwordEncoder.encode("123456");
        log.info("test: " + test);
        return "login";
    }
}
