package com.eavendano.patterns.service;

import com.eavendano.patterns.common.exceptions.NotFoundException;
import com.eavendano.patterns.common.exceptions.ServiceException;
import com.eavendano.patterns.common.models.SampleModel;
import com.eavendano.patterns.common.patterns.WorkflowContext;
import com.eavendano.patterns.common.patterns.WorkflowFactory;
import com.eavendano.patterns.data.SampleRepository;
import com.eavendano.patterns.data.SettingRepository;
import com.eavendano.patterns.data.entities.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.eavendano.patterns.common.models.SampleModel.fromEntity;

@Service
public class SampleServiceImpl implements SampleService {

    private SampleRepository sampleRepository;
    private SettingRepository settingRepository;
    private WorkflowFactory workflowFactory;

    /**
     * Note: I truly do not recommend the use of transactional annotation.
     * We are using it for the sake of the sample and context.
     * We recommend the programmatic approach, here you can read about it:
     * https://www.baeldung.com/spring-programmatic-transaction-management
     **/
    @Transactional
    @Override
    public SampleModel findSampleByName(final String name) {
        final Optional<Sample> sampleResult = sampleRepository.findSampleByName(name);
        if (sampleResult.isEmpty()) {
            throw new NotFoundException("Unable to find sample with name: " + name);
        }

        return fromEntity(sampleResult.get());
    }

    @Transactional
    @Override
    public SampleModel createSample(final SampleModel model) {
        /**
         try {
         var optionalSample = ofNullable(sampleRepository.insert(toEntity(model)));
         if (optionalSample.isEmpty()) {
         throw new ServiceException(format("Failed to insert sample: [%s]", model));
         }
         return fromEntity(optionalSample.get());
         } catch (DataAccessException ex) {
         throw new ServiceException(format("Unable to connect to services for sample: [%s]", model), ex);
         } catch (Exception ex) {
         throw new ServiceException(format("Unknown issue occurred for sample: [%s]", model), ex);
         }
         **/
        var workflowContext = new WorkflowContext()
                .setSampleParameter(model)
                .setSampleRepository(sampleRepository)
                .setSettingRepository(settingRepository);
        var definedWorkflow = workflowFactory.defineWorkflow(workflowContext);
        if (definedWorkflow.isEmpty()) {
            throw new ServiceException("Unable to define workflow for sample");
        }

        return definedWorkflow.get().execute();
    }

    @Autowired
    public void setSampleRepository(final SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Autowired
    public void setSettingRepository(final SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Autowired
    public void setWorkflowFactory(final WorkflowFactory workflowFactory) {
        this.workflowFactory = workflowFactory;
    }
}
