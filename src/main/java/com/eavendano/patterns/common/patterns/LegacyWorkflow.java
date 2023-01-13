package com.eavendano.patterns.common.patterns;

import com.eavendano.patterns.common.exceptions.ServiceException;
import com.eavendano.patterns.common.models.SampleModel;
import org.springframework.dao.DataAccessException;

import static com.eavendano.patterns.common.models.SampleModel.fromEntity;
import static com.eavendano.patterns.common.models.SampleModel.toEntity;
import static java.lang.String.format;
import static java.util.Optional.ofNullable;

public class LegacyWorkflow implements Command {

    private WorkflowContext context;

    @Override
    public SampleModel execute() {
        var model = context.getSampleParameter();
        try {
            var optionalSample = ofNullable(context.getSampleRepository().insert(toEntity(model)));
            if (optionalSample.isEmpty()) {
                throw new ServiceException(format("Failed to insert sample: [%s]", model));
            }
            return fromEntity(optionalSample.get());
        } catch (DataAccessException ex) {
            throw new ServiceException(format("Unable to connect to services for sample: [%s]", model), ex);
        } catch (Exception ex) {
            throw new ServiceException(format("Unknown issue occurred for sample: [%s]", model), ex);
        }
    }

    public LegacyWorkflow setContext(final WorkflowContext context) {
        this.context = context;
        return this;
    }
}
