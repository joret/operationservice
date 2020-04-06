package com.bloomberg.server.arithmeticservice.models;

import lombok.Data;

import java.util.List;

@Data
public class Expression {
    Character operation;
    List<Double> numbers;
}
