package com.pinhobrunodev.attendancems.frameworks.adapters.outbound.persistence.user;

import com.pinhobrunodev.attendancems.frameworks.adapters.outbound.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserMongoRepository extends MongoRepository<UserEntity,String> {

    Optional<UserEntity> findByUserId(UUID userId);
}
