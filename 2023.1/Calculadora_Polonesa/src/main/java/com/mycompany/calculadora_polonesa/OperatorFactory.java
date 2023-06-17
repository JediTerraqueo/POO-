package com.mycompany.calculadora_polonesa;

public class OperatorFactory {
    public static Operator createOperator(String operator) {
        switch (operator) {
            case "+":
                return new AdditionOperator();
            case "-":
                return new SubtractionOperator();
            case "*":
                return new MultiplicationOperator();
            case "/":
                return new DivisionOperator();
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
