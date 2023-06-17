package com.mycompany.calculadora_polonesa;

public class Main {
    public static void main(String[] args) {
        String expression = "2 _a * _b + _b *";
        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        double result = interpreter.interpret(expression);
        System.out.println("Result: " + result);
    }
}
