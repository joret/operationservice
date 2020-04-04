package com.bloomberg.server.arithmeticservice.businesslogic.interfaces;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionSolverException;

public interface IExpressionSolver {
    double evaluate(String expression) throws ExpressionSolverException;
}
