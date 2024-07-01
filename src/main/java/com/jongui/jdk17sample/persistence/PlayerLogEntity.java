package com.jongui.jdk17sample.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user_log")
public class PlayerLogEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer seq;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = true)
    private PlayerEntity playerLogEntity;
}
