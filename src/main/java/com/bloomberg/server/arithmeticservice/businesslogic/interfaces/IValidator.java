package com.bloomberg.server.arithmeticservice.businesslogic.interfaces;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.BadParametersException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ServerException;
import com.bloomberg.server.arithmeticservice.configuration.OperationsConfig;
import com.bloomberg.server.arithmeticservice.models.Expression;

public interface IValidator {
    void validate(Expression expression, OperationsConfig operationsConfig) throws BadParametersException, ServerException;
}
