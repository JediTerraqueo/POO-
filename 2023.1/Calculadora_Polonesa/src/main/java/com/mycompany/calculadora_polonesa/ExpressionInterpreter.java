package com.mycompany.calculadora_polonesa;

import java.util.ArrayList;
import java.util.List;

public class ExpressionInterpreter {
    private Context context;
    private List<TokenHandler> tokenHandlers;

    public ExpressionInterpreter() {
        context = new Context();
        tokenHandlers = new ArrayList<>();
        tokenHandlers.add(new VariableTokenHandler());
        tokenHandlers.add(new ExpressionTokenHandler());
    }

    public double interpret(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            for (TokenHandler handler : tokenHandlers) {
                handler.handleToken(token, context);
                if (context.isValueReady()) {
                    break;
                }
            }
        }
        return context.popValue();
    }
}
