package com.bloomberg.server.arithmeticservice.controllers;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.BadParametersException;
import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionSolverException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IExpressionSolver;
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
    IExpressionSolver expressionSolver;
    OperationsConfig operationsConfig;

    @Autowired
    public OperationController(IExpressionSolver expressionSolver, OperationsConfig operationsConfig){
        this.expressionSolver = expressionSolver;
        this.operationsConfig = operationsConfig;
    }

    @ResponseBody
    @RequestMapping(value = "/operation", method = POST, consumes = "application/json")
    public String arithmeticOperation(@RequestBody Expression expression) throws BadParametersException, ExpressionSolverException {

            logger.info("Access /operation");
                //TODO swagger
                //TODO fix tests
                //TODO version API
                //TODO validate expression before using, just to avoid misuse or abuse
                //TODO Class operation seems not to be needed anymore, change with a simple string if thats the case
                //TODO check test coverage
                //TODO enable docker compose
                //TODO add caffeine cache
            //TODO add fallback
                //Set fallback to website that calculates or to localhost

                if(expression != null && operationsConfig != null){


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

                    var expressionStr = new StringBuilder();
                    for (int i = 0; i < quantityOfNumbers; i++) {
                        var number = expression.getNumbers().get(i);
                        expressionStr.append(number);

                        if(i < quantityOfNumbers - 1)
                            expressionStr.append(expression.getOperation());
                    }


                    var result = expressionSolver.evaluate(expressionStr.toString());
                    // TODO version API
                    //Return mono map
                    return "{\"result\":" + result  + "}";
                }
                return "{result: null}";
    }
}
