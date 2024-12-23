package com.meac.todolistapi.services.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ApiError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private String message;
    private List<String> errors = new ArrayList<>();

    public ApiError(Instant timestamp, String message, List<String> errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
