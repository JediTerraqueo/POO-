package com.mycompany.calculadora_polonesa;

public class ExpressionTokenHandler implements TokenHandler {
    @Override
    public void handleToken(String token, Context context) {
        try {
            double value = Double.parseDouble(token);
            context.pushValue(value);
        } catch (NumberFormatException e) {
            // Token is an operator
            Operator operator = OperatorFactory.createOperator(token);
            operator.execute(context);
        }
    }
}
