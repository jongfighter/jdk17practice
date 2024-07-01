package com.jongui.jdk17sample.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "admin_user")
public class AdminUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String password;
    private String nickname;
    private Boolean isDeleted;

    @OneToMany(mappedBy = "user")
    private Set<AdminUserAuthorityEntity> adminUserAuthorityEntities = new HashSet<>();

}
