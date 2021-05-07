package com.example.SpringBootActuator.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DatabaseService implements HealthIndicator {
    private final String DATABASE_SERVICE = "Database Service";

    @Override
    public Health health() {
        if(isDatabaseHealth()) {
            return Health.up().withDetails(
                    Stream.of(new String[][]{
                            {"Name", DATABASE_SERVICE},
                            {"Status", "Database is running"},
                            {"Space", "Database is using X Space"}
                    }).collect(Collectors.toMap(data -> data[0], data -> data[1]))
            ).build();
        }
        return Health.down().withDetail(DATABASE_SERVICE, "Database is not available").build();
    }

    private boolean isDatabaseHealth() {
        /* Some Logic to Check the Health of the Database */
        return true;
    }
}
