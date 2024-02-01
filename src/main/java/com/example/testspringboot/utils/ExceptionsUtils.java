package com.example.testspringboot.utils;

import java.util.Arrays;

public class ExceptionsUtils {
    public static final String DEFAULT_EXCEPTION_MESSAGE = "Something went wrong, please try again later";

    public static String createStackTraceForException(Exception exception) {
        StringBuilder stackTrace = new StringBuilder();
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> stackTrace
                .append("Class name: ").append(stackTraceElement.getClassName())
                .append(", method: ").append(stackTraceElement.getMethodName())
                .append(", line: ").append(stackTraceElement.getLineNumber())
                .append("\n"));

        return stackTrace.toString();
    }
}
