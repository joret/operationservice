package com.bloomberg.server.arithmeticservice.controllers;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.BadParametersException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionBuildException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionSolverException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ServerException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IExpressionBuilder;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IExpressionSolver;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IValidator;
import com.bloomberg.server.arithmeticservice.configuration.OperationsConfig;
import com.bloomberg.server.arithmeticservice.models.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class OperationController {
    private static Logger logger = LoggerFactory.getLogger(OperationController.class);
    private IExpressionSolver expressionSolver;
    private OperationsConfig operationsConfig;
    private IValidator validator;
    private IExpressionBuilder expressionBuilder;

    @Autowired
    public OperationController(IExpressionSolver expressionSolver, OperationsConfig operationsConfig,
                               IValidator validator, IExpressionBuilder expressionBuilder){
        this.expressionSolver = expressionSolver;
        this.operationsConfig = operationsConfig;
        this.validator = validator;
        this.expressionBuilder = expressionBuilder;
    }

    @ResponseBody
    @RequestMapping(value = "/operation", method = POST, consumes = "application/json")
    public String arithmeticOperation(@RequestBody Expression expression) throws BadParametersException,
            ExpressionSolverException, ExpressionBuildException, ServerException {

                if(expression != null && operationsConfig != null){

                    validator.validate(expression, operationsConfig);

                    var expressionStr = expressionBuilder.build(expression);
                    var result = expressionSolver.evaluate(expressionStr);

                    logger.info("POST /operation\tNumbers:" + expression.getNumbers().toString()
                            + "\tOperator:" + expression.getOperation() + "\tResult:" + result);
                    return "{\"result\":" + result  + "}";
                }
                return "{result: null}";
    }
}
