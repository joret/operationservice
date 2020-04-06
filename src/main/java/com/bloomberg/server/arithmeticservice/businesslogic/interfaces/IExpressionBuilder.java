package com.bloomberg.server.arithmeticservice.businesslogic.interfaces;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionBuildException;
import com.bloomberg.server.arithmeticservice.models.Expression;

public interface IExpressionBuilder {
    String build(Expression expression) throws ExpressionBuildException;
}
