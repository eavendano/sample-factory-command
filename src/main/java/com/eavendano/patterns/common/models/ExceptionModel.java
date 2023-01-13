package com.eavendano.patterns.common.models;

import java.util.List;

public class ExceptionModel {

    private String message;
    private List<String> devMessages;

    public String getMessage() {
        return message;
    }

    public ExceptionModel setMessage(final String message) {
        this.message = message;
        return this;
    }

    public List<String> getDevMessages() {
        return devMessages;
    }

    public ExceptionModel setDevMessages(final List<String> devMessages) {
        this.devMessages = devMessages;
        return this;
    }
}
