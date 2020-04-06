package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionBuildException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionSolverException;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionBuilderTest {
    //TODO under development

    @Test
    void When_NullExpression_Throws_ExpressionException(){
        var sut = new ExpressionBuilder();
        assertThrows(ExpressionBuildException.class, () ->sut.build(null));
    }

    @Test
    void When_DefaultExpression_Throw_ExpressionBuildException() throws ExpressionBuildException {
        var sut = new ExpressionBuilder();
        var expression = new Expression();

        assertThrows(ExpressionBuildException.class, () ->sut.build(expression));
    }

    @Test
    void When_ValidExpression_Return_StringRepresentationOfExpression() throws ExpressionBuildException {
        var sut = new ExpressionBuilder();
        var expression = new Expression();
        expression.setNumbers(List.of(3.0, 4.0));
        expression.setOperation('+');

        String result = sut.build(expression);
        assertEquals("3.0+4.0",result);
    }
}