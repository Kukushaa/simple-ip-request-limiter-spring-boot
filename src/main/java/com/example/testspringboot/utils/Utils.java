package com.example.testspringboot.utils;

import java.util.Base64;

public class Utils {
    public static String hashString(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }
}
