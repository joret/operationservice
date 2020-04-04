package com.bloomberg.server.arithmeticservice.businesslogic.exceptions;

public class ExpressionSolverException extends Exception {
    public ExpressionSolverException(Exception e){
        super(e);
    }

    public ExpressionSolverException(String message, Exception e){
        super(message, e);
    }
}
