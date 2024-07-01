package com.jongui.jdk17sample.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user_log")
public class UserLogEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer seq;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity user;
}
