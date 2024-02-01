package com.example.testspringboot.exception;

public class IpRateLimiterException extends CustomException {
    public IpRateLimiterException() {
    }

    public IpRateLimiterException(String message) {
        super(message);
    }

    public IpRateLimiterException(String message, Throwable cause) {
        super(message, cause);
    }

    public IpRateLimiterException(Throwable cause) {
        super(cause);
    }

    public IpRateLimiterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
