package com.mycompany.calculadora_polonesa;

public class VariableTokenHandler implements TokenHandler {
    @Override
    public void handleToken(String token, Context context) {
        if (token.startsWith("_")) {
            String variableName = token.substring(1);
            double variableValue = context.getVariableValue(variableName);
            context.pushValue(variableValue);
        }
    }
}
