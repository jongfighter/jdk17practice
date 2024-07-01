package com.jongui.jdk17sample.site.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogDto {

    public Integer logId;
    private Integer userId;

}
