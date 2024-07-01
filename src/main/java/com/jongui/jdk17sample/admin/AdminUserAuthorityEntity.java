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
@Entity
@Table(name = "user_authority")
public class AdminUserAuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AdminUserEntity user;
    @ManyToOne
    @JoinColumn(name = "authority_id")
    private AdminAuthorityEntity authority;

}
