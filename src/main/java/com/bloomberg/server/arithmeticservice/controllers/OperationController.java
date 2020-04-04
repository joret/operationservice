package com.bloomberg.server.arithmeticservice.controllers;

import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IExpressionSolver;
import com.bloomberg.server.arithmeticservice.models.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class OperationController {
    IExpressionSolver expressionSolver;

    public OperationController(IExpressionSolver expressionSolver){
        this.expressionSolver = expressionSolver;
    }

    @ResponseBody
    @RequestMapping(value = "/operation", method = POST, consumes = "application/json")
    public String arithmeticOperation(@RequestBody Operation operation) {
        try{


                //TODO validate expression before using
                //TODO Class operation seems not to be needed anymore, change with a simple string if thats the case
                var result = expressionSolver.evaluate(operation.getOperation());
                // TODO version API
                return "{\"result\":" + result + "}";


        } catch (Exception e){
            return "{result: null}";
        }
    }
}
