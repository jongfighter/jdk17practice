package com.jongui.jdk17sample.mongo.userlog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Document(collection = "user_login")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserLoginLog {
    @Id
    private String id;
    private String nickname;
    private String ip;
    private String loginType;
    @Field(targetType = FieldType.DATE_TIME)
    private LocalDateTime loginDate;

}
