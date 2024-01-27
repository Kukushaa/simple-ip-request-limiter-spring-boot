package com.example.testspringboot.annotation;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IpRateLimitData {
    private int amount;
    private Date requestDate;

    public static IpRateLimitData setDefaultData() {
        return new IpRateLimitData(1, new Date());
    }

    public long getTimeDiffInSeconds() {
        return new Date(new Date().getTime() - getRequestDate().getTime()).getTime() / 1000;
    }
}