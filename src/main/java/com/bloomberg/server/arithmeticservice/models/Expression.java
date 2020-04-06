package com.bloomberg.server.arithmeticservice.models;

import lombok.Data;

import java.util.List;

@Data
public class Operation {
    Character operation;
    List<Double> numbers;
}
