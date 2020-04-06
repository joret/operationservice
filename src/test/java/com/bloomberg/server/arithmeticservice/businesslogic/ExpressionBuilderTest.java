package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.configuration.OperationsConfig;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionBuilderTest {
    @Test
        //TODO under development
    void build_WhenNullConfig_Return(){
        var sut = new ExpressionBuilder();
        var expression = new Expression();

        sut.build(expression, null);
    }
}