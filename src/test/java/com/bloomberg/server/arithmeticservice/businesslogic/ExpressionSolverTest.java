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
    @Test
    void evaluate_When_ExpressionSumThreePlusTwo_Return_Five() throws ExpressionSolverException {
        var sut = new ExpressionSolver();

        var result = sut.evaluate("3+2");
        Assert.assertEquals(5, result, 0);
    }

    @Test
    void evaluate_When_ExpressionAllSpaces_Throw_ExpressionSolverException() {
        var sut =  new ExpressionSolver();

        assertThrows(ExpressionSolverException.class, () ->sut.evaluate("  "));
    }

    @Test
    void evaluate_When_ExpressionEmpty_Throw_ExpressionSolverException() {
        var sut =  new ExpressionSolver();

        assertThrows(ExpressionSolverException.class, () ->sut.evaluate(""));
    }

    @Test
    void evaluate_When_ExpressionNull_Return_Empty() {
        var sut =  new ExpressionSolver();

        assertThrows(ExpressionSolverException.class, () ->sut.evaluate(null));
    }
}