package com.bloomberg.server.arithmeticservice.businesslogic;

import com.bloomberg.server.arithmeticservice.businesslogic.exceptions.ExpressionSolverException;
import com.bloomberg.server.arithmeticservice.businesslogic.interfaces.IExpressionSolver;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class ExpressionSolver implements IExpressionSolver {

    @Override
    public double evaluate(String expression) throws ExpressionSolverException {

        try{
            var exec = Executors.newSingleThreadExecutor();
            var e = new ExpressionBuilder(expression).build();

            Future<Double> future = e.evaluateAsync(exec);

            return future.get();
        } catch (Exception e){
            throw new ExpressionSolverException(e);
        }

    }
}
