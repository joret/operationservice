package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionSolverException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IExpressionSolver;
import com.bloomberg.server.arithmeticservice.configuration.OperationsConfig;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionSolverTest {
    private final IExpressionSolver expressionSolver = new ExpressionSolver();

    @Test
    void When_ExpressionSumThreePlusTwo_Return_Five() throws ExpressionSolverException {
        var result = expressionSolver.evaluate("3+2");
        Assert.assertEquals(5, result, 0);
    }

    @Test
    void When_ExpressionAllSpaces_Throw_ExpressionSolverException() {
        assertThrows(ExpressionSolverException.class, () ->expressionSolver.evaluate("  "));
    }

    @Test
    void When_ExpressionEmpty_Throw_ExpressionSolverException() {
        assertThrows(ExpressionSolverException.class, () ->expressionSolver.evaluate(""));
    }

    @Test
    void When_ExpressionNull_Return_Empty() {
        assertThrows(ExpressionSolverException.class, () ->expressionSolver.evaluate(null));
    }
}