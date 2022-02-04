package com.pinhobrunodev.sendemailms.frameworks.adapters.outbound.persistence;

import com.pinhobrunodev.sendemailms.frameworks.adapters.outbound.entities.EmailEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailMongoRepository extends MongoRepository<EmailEntity, String> {
}
