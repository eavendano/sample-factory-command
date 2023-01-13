package com.eavendano.patterns.controller;

import com.eavendano.patterns.common.models.SampleModel;
import com.eavendano.patterns.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {

    private SampleService sampleService;

    @GetMapping(value = "/{name}")
    @ResponseBody
    public SampleModel findSampleModelByName(@PathVariable final String name) {
        return sampleService.findSampleByName(name);
    }

    @PostMapping
    @ResponseBody
    public SampleModel createSampleModel(@RequestBody final SampleModel model) {
        return sampleService.createSample(model);
    }

    @Autowired
    public void setSampleService(final SampleService sampleService) {
        this.sampleService = sampleService;
    }
}
