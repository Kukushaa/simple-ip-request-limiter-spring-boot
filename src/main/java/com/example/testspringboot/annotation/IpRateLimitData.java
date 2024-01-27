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
}