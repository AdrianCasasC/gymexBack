package com.adridev.gymex.models;

import org.springframework.http.HttpStatusCode;

public class ResponseStatusError {
    private HttpStatusCode status;
    private String message;

    public ResponseStatusError(HttpStatusCode status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseStatusError() {
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseStatusError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
