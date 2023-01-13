package com.eavendano.patterns.data;

import com.eavendano.patterns.data.entities.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SampleRepository extends MongoRepository<Sample, String> {

    Optional<Sample> findSampleByName(final String name);
}
