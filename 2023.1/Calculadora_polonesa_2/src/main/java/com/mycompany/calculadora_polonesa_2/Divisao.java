package com.mycompany.calculadora_polonesa_2;

import java.util.Stack;

// Implementação da operação de divisão
class Divisao implements Operacao {
    @Override
    public double calcular(Stack<Double> pilha) {
        double a = pilha.pop();
        double b = pilha.pop();
        if (a == 0) {
            throw new IllegalArgumentException("Divisão por zero");
        }
        return b / a;
    }
}
