package com.jongui.jdk17sample.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "authority")
@Entity
public class AdminAuthorityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "auth_name")
    private String authorityName;
    private Boolean isDeleted;
}
