package com.bloomberg.server.arithmeticservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Operation {

    @JsonProperty("operation_type")
    private String operationType;
    private List<Double> numbers;
}
