package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.BadParametersException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionSolverException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ServerException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IValidator;
import com.bloomberg.server.arithmeticservice.configuration.OperationsConfig;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ParameterValidatorTest {
    private final IValidator validator = new ParameterValidator();

    @Test
    void When_AllParametersNull_Throws_BadParameterException() {
        assertThrows(BadParametersException.class, () -> validator.validate(null, null));
    }

    @Test
    void When_ExpressionNull_Throws_BadParametersException() {
        var operationConfig =  new OperationsConfig();
        assertThrows(BadParametersException.class, () -> validator.validate(null, operationConfig));
    }

    @Test
    void When_ConfigNull_Throws_ServerException() {
        var expression = new Expression();
        assertThrows(ServerException.class, () -> validator.validate(expression, null));
    }

    @Test
    void When_NotAllowedOperatorInExpression_Throws_BadParameterException() {
        var expression = new Expression();
        expression.setOperation('%');
        var operationConfig =  new OperationsConfig();
        assertThrows(BadParametersException.class, () -> validator.validate(expression, operationConfig));
    }

    @Test
    void When_NullNumbersInExpression_Throws_BadParameterException() {
        var expression = new Expression();
        expression.setOperation('+');
        var operationConfig =  new OperationsConfig();
        operationConfig.setAllowed(Set.of('+'));
        assertThrows(BadParametersException.class, () -> validator.validate(expression, operationConfig));
    }

    @Test
    void When_EmptyOperatorInExpression_Throws_BadParameterException() {
        var expression = new Expression();
        expression.setNumbers(List.of(3.0, 10.0));
        var operationConfig =  new OperationsConfig();
        assertThrows(BadParametersException.class, () -> validator.validate(expression, operationConfig));
    }

    @Test
    void When_EmptyAllowedOperations_Throws_BadServer() {
        var expression = new Expression();
        expression.setNumbers(List.of(3.0, 10.0));
        expression.setOperation('+');
        var operationConfig =  new OperationsConfig();
        operationConfig.setAllowed(null);
        operationConfig.setGetRequiredQuantityNumbers(2);
        assertThrows(ServerException.class, () -> validator.validate(expression, operationConfig));
    }

    @Test
    void When_NumbersLessThanRequired_Throws_BadParameterException() {
        var expression = new Expression();
        expression.setOperation('+');
        expression.setNumbers(List.of(3.0));
        var operationConfig =  new OperationsConfig();
        operationConfig.setGetRequiredQuantityNumbers(2);
        operationConfig.setAllowed(Set.of('+'));
        assertThrows(BadParametersException.class, () -> validator.validate(expression, operationConfig));
    }

    @Test
    void When_WhiteSpaceOperatorInExpression_Throws_BadParameterException() {
        var expression = new Expression();
        expression.setOperation(' ');
        expression.setNumbers(List.of(3.0, 10.0));
        var operationConfig =  new OperationsConfig();
        assertThrows(BadParametersException.class, () -> validator.validate(expression, operationConfig));
    }
}