package com.pinhobrunodev.attendancems.frameworks.adapters.outbound.persistence;

import com.pinhobrunodev.attendancems.frameworks.adapters.outbound.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserMongoRepository extends CrudRepository<UserEntity,String> {
}
