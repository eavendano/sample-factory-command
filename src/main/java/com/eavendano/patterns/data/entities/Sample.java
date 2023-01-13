package com.eavendano.patterns.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("samples")
public class Sample {

    @Id
    private String id;
    private String name;
    private String description;
    private String value;

    public String getId() {
        return id;
    }

    public Sample setId(final String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sample setName(final String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Sample setDescription(final String description) {
        this.description = description;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Sample setValue(final String value) {
        this.value = value;
        return this;
    }
}
