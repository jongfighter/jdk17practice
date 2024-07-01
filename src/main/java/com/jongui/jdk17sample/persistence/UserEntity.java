package com.jongui.jdk17sample.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_user")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    private Integer cnt;
    @OneToMany(mappedBy = "user")
    public List<UserLogEntity> userLogEntityList = new ArrayList<>();
   @OneToOne
    @JoinColumn(name = "playerId")
    private PlayerEntity playerEntity;

}
