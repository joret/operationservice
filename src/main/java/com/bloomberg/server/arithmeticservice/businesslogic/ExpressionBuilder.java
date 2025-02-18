package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionBuildException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IExpressionBuilder;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.springframework.stereotype.Service;

@Service
public class ExpressionBuilder implements IExpressionBuilder {


    @Override
    public String build(Expression expression) throws ExpressionBuildException {
        if(expression == null || expression.getNumbers() == null || expression.getOperation() == null)
            throw new ExpressionBuildException("Null expression");

        var quantityOfNumbers = expression.getNumbers().size();
        var expressionStr = new StringBuilder();
        for (int i = 0; i < quantityOfNumbers; i++) {
            var number = expression.getNumbers().get(i);
            expressionStr.append(number);

            if(i < quantityOfNumbers - 1)
                expressionStr.append(expression.getOperation());
        }
        return  expressionStr.toString();
    }
}
