package com.mycompany.calculadora_polonesa;

import java.util.Stack;

public class Context {
    private Stack<Double> valueStack;

    public Context() {
        valueStack = new Stack<>();
    }

    public void pushValue(double value) {
        valueStack.push(value);
    }

    public double popValue() {
        return valueStack.pop();
    }

    public boolean isValueReady() {
        return valueStack.size() == 1;
    }

    public double getVariableValue(String variableName) {
        // Implementar a lógica para obter o valor da variável
        return 0.0; // Retornar um valor padrão
    }
}
