package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.BadParametersException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ServerException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IValidator;
import com.bloomberg.server.arithmeticservice.configuration.OperationsConfig;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.springframework.stereotype.Service;

@Service
public class ParameterValidator implements IValidator {
    public void validate(Expression expression, OperationsConfig operationsConfig) throws BadParametersException, ServerException {
        if(expression == null)
            throw new BadParametersException("Null expression");

        if(operationsConfig == null)
            throw new ServerException("No operations configuration set up on the server");

        if(expression.getOperation() == null
                || Character.isWhitespace(expression.getOperation())
                ) {
            throw new BadParametersException("No operations found in expression");
        }

        if (operationsConfig.getAllowed() != null) {
            if (!operationsConfig.getAllowed().contains(expression.getOperation())) {
                throw new BadParametersException("Forbidden operation. Allowed operations:"
                        + operationsConfig.getAllowed().toString());
            }
        } else {
            throw new ServerException("No operations configured in server");
        }

        if(expression.getNumbers() == null){
            throw new BadParametersException("No numbers in expression");
        }


        var quantityOfNumbers = expression.getNumbers().size();
        if(expression.getNumbers() == null
                || quantityOfNumbers <= 0
                || quantityOfNumbers != operationsConfig.getGetRequiredQuantityNumbers()){
            throw new BadParametersException(
                    "Wrong quantity of numbers: "
                            + quantityOfNumbers
                            + ". Allowed quantity of numbers:"
                            + operationsConfig.getGetRequiredQuantityNumbers());
        }
    }
}
