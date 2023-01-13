package com.eavendano.patterns.common.patterns;

import com.eavendano.patterns.common.models.SampleModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class WorkflowFactory {

    public Optional<Command<SampleModel>> defineWorkflow(final WorkflowContext context) {
        var optSetting = context.getSettingRepository().findSettingByName("WORKFLOW_FLAG_SETTING");
        if (optSetting.isPresent()) {
            var setting = optSetting.get();
            if ("TRUE".equals(setting.getValue())) {
                return of(new NewWorkflowCommand().setContext(context));
            }
            return of(new LegacyWorkflow().setContext(context));
        }
        return empty();
    }
}
