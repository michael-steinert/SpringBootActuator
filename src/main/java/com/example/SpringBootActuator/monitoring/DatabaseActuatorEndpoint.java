package com.example.SpringBootActuator.monitoring;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Endpoint(id = "database")
@Component
public class DatabaseActuatorEndpoint {
    private final String DATABASE_SERVICE = "Database Service";

    @ReadOperation
    public Map<String, String> databaseEndpoint() {
        return Stream.of(new String[][]{
                {"Name", DATABASE_SERVICE},
                {"Status", "Database is running"},
                {"Space", "Database is using X Space"}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    }
}
