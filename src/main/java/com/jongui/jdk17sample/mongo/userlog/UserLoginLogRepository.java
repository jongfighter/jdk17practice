package com.jongui.jdk17sample.mongo.userlog;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserLoginLogRepository extends ReactiveMongoRepository<UserLoginLog, String>{
}
