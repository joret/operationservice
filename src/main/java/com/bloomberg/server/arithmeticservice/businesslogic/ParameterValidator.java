package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.BadParametersException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IValidator;
import com.bloomberg.server.arithmeticservice.configuration.OperationsConfig;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.springframework.stereotype.Service;

@Service
public class ParameterValidator implements IValidator {
    public void validate(Expression expression, OperationsConfig operationsConfig) throws BadParametersException {
        if(expression.getOperation() == null
                || Character.isWhitespace(expression.getOperation())
                || !operationsConfig.getAllowed().contains(expression.getOperation())){
            throw new BadParametersException("Forbidden operation. Allowed operations:"
                    + operationsConfig.getAllowed().toString());
        }

        var quantityOfNumbers = expression.getNumbers().size();
        if(expression.getNumbers() == null
                || quantityOfNumbers <= 0
                || quantityOfNumbers != operationsConfig.getMaxNumbers()){
            throw new BadParametersException(
                    "Wrong quantity of numbers: "
                            + quantityOfNumbers
                            + ". Allowed quantity of numbers:"
                            + operationsConfig.getMaxNumbers());
        }
    }
}
