package com.eavendano.patterns.service;

import com.eavendano.patterns.common.models.SampleModel;

public interface SampleService {
    SampleModel findSampleByName(final String name);
    SampleModel createSample(final SampleModel model);
}
