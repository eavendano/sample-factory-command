package com.eavendano.patterns.common.patterns;

import com.eavendano.patterns.common.models.SampleModel;
import com.eavendano.patterns.data.SampleRepository;
import com.eavendano.patterns.data.SettingRepository;

public class WorkflowContext {

    private SettingRepository settingRepository;
    private SampleRepository sampleRepository;
    private SampleModel sampleParameter;

    public SettingRepository getSettingRepository() {
        return settingRepository;
    }

    public WorkflowContext setSettingRepository(final SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
        return this;
    }

    public SampleRepository getSampleRepository() {
        return sampleRepository;
    }

    public WorkflowContext setSampleRepository(final SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
        return this;
    }

    public SampleModel getSampleParameter() {
        return sampleParameter;
    }

    public WorkflowContext setSampleParameter(final SampleModel sampleParameter) {
        this.sampleParameter = sampleParameter;
        return this;
    }
}
