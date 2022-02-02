package com.pinhobrunodev.userms.frameworks.adapters.outbound.persistence;

import com.pinhobrunodev.userms.frameworks.adapters.outbound.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserJpaRepository extends CrudRepository<UserEntity, UUID> {
}
