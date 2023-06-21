package com.mycompany.calculadora_polonesa_2;

import java.util.Stack;

// Implementação da operação de multiplicação
class Multiplicacao implements Operacao {
    @Override
    public double calcular(Stack<Double> pilha) {
        double a = pilha.pop();
        double b = pilha.pop();
        return a * b;
    }
}

