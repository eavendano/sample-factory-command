package com.eavendano.patterns.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("settings")
public class Setting {

    @Id
    private String id;
    private String name;
    private String value;

    public String getId() {
        return id;
    }

    public Setting setId(final String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Setting setName(final String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Setting setValue(final String value) {
        this.value = value;
        return this;
    }
}
