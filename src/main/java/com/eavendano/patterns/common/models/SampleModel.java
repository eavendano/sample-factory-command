package com.eavendano.patterns.common.models;

import com.eavendano.patterns.data.entities.Sample;

public class SampleModel {

    private String id;
    private String name;
    private String description;
    private String value;

    public String getId() {
        return id;
    }

    public SampleModel setId(final String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SampleModel setName(final String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SampleModel setDescription(final String description) {
        this.description = description;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SampleModel setValue(final String value) {
        this.value = value;
        return this;
    }

    public static SampleModel fromEntity(final Sample sample) {
        return new SampleModel()
                .setId(sample.getId())
                .setName(sample.getName())
                .setValue(sample.getValue())
                .setDescription(sample.getDescription());
    }

    public static Sample toEntity(final SampleModel model) {
        return new Sample()
                .setId(model.getId())
                .setName(model.getName())
                .setValue(model.getValue())
                .setDescription(model.getDescription());
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this, org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE)
                .append("__class__", this.getClass().getSimpleName())
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("value", value)
                .toString();
    }
}
