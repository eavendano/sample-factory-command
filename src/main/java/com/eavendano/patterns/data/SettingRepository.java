package com.eavendano.patterns.data;

import com.eavendano.patterns.data.entities.Setting;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SettingRepository extends MongoRepository<Setting, String> {

    Optional<Setting> findSettingByName(final String name);
}
