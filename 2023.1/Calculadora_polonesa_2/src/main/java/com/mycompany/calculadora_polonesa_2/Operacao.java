package com.mycompany.calculadora_polonesa_2;

import java.util.Stack;

// Interface para as operações aritméticas
interface Operacao {
    double calcular(Stack<Double> pilha);
}
