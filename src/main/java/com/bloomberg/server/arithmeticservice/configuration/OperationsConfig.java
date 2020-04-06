package com.bloomberg.server.arithmeticservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@ConfigurationProperties("operations")
@Data
public class OperationsConfig {
    private Integer maxNumbers = 2;
    private Set<Character> allowed = Set.of('+');
}