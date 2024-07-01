package com.jongui.jdk17sample.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_player")
@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private Integer balnce;

   @OneToOne(mappedBy = "playerEntity")
    private UserEntity userEntity;
}
