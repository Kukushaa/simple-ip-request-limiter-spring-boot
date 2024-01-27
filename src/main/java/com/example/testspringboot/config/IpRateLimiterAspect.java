package com.example.testspringboot.config;

import com.example.testspringboot.annotation.IpRateLimit;
import com.example.testspringboot.annotation.IpRateLimitData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class IpRateLimiterAspect {
    private final Map<String, IpRateLimitData> ipRateLimitDataMap = new HashMap<>();

    @Around("@annotation(ipRateLimit)")
    public Object limit(ProceedingJoinPoint joinPoint, IpRateLimit ipRateLimit) throws Throwable {
        String ip = joinPoint.getKind();
        String key = "ip-" + ip;

        if (isRateLimited(key, ipRateLimit.limit(), ipRateLimit.duration())) {
            throw new RuntimeException("Rate limit exceeded for IP: " + ip);
        }

        return joinPoint.proceed();
    }

    public boolean isRateLimited(String key, int limit, int duration) {
        IpRateLimitData ipRateLimitData = ipRateLimitDataMap.get(key);

        boolean finalAns = false;

        if (ipRateLimitData == null) {
            ipRateLimitData = new IpRateLimitData(1, new Date());
        } else {
            if (ipRateLimitData.getAmount() >= limit) {
                if (new Date(new Date().getTime() - ipRateLimitData.getRequestDate().getTime()).getTime() / 1000 < duration) {
                    finalAns = true;
                } else {
                    ipRateLimitData = new IpRateLimitData(1, new Date());
                }
            } else {
                ipRateLimitData.setAmount(ipRateLimitData.getAmount() + 1);
            }
        }

        ipRateLimitDataMap.put(key, ipRateLimitData);

        return finalAns;
    }
}
