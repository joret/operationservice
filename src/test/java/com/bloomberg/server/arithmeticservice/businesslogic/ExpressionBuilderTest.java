package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionBuildException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionSolverException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IExpressionBuilder;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionBuilderTest {
    IExpressionBuilder expressionBuilder = new ExpressionBuilder();

    @Test
    void When_NullExpression_Throws_ExpressionException(){
        assertThrows(ExpressionBuildException.class, () ->expressionBuilder.build(null));
    }

    @Test
    void When_DefaultExpression_Throws_ExpressionBuildException() throws ExpressionBuildException {
        var expression = new Expression();

        assertThrows(ExpressionBuildException.class, () ->expressionBuilder.build(expression));
    }

    @Test
    void When_ExpressionWithValidOperationButNullNumbers_Throws_ExpressionBuildException() throws ExpressionBuildException {
        var expression = new Expression();
        expression.setOperation('+');

        assertThrows(ExpressionBuildException.class, () ->expressionBuilder.build(expression));
    }

    @Test
    void When_ValidExpression_Return_StringRepresentationOfExpression() throws ExpressionBuildException {
        var expression = new Expression();
        expression.setNumbers(List.of(3.0, 4.0));
        expression.setOperation('+');

        String result = expressionBuilder.build(expression);
        assertEquals("3.0+4.0",result);
    }
}