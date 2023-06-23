package com.mycompany.calculadora_polonesa_2;

import java.util.HashMap;
import java.util.Map;

public class CalculadoraFacade {
    private Pilha<Double> pilha;
    private Map<String, Double> variaveis;

    public CalculadoraFacade() {
        this.pilha = new Pilha<>();
        this.variaveis = new HashMap<>();
    }

    public double calcularExpressao(String expressao) {
        pilha.clear();

        String[] tokens = expressao.split(" ");

        for (String token : tokens) {
            if (isOperador(token)) {
                double operando2 = pilha.pop();
                double operando1 = pilha.pop();
                double resultado = executarOperacao(token, operando1, operando2);
                pilha.push(resultado);
            } else if (isVariavel(token)) {
                double valor = getValorVariavel(token);
                pilha.push(valor);
            } else {
                double numero = Double.parseDouble(token);
                pilha.push(numero);
            }
        }

        if (pilha.isEmpty()) {
            throw new RuntimeException("A pilha está vazia. Verifique a expressão.");
        }

        return pilha.pop();
    }

    public void adicionarVariavel(String nome, double valor) {
        variaveis.put(nome, valor);
    }

    public double getValorVariavel(String nome) {
        if (!variaveis.containsKey(nome)) {
            throw new IllegalArgumentException("Variável não encontrada: " + nome);
        }
        return variaveis.get(nome);
    }

    public Map<String, Double> getVariaveis() {
        return variaveis;
    }

    public void limparVariaveis() {
        variaveis.clear();
    }

    private boolean isOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^") ||
                token.equals("log") || token.equals("sin") || token.equals("cos") || token.equals("tan") ||
                token.equals("exp");
    }

    private boolean isVariavel(String token) {
        return variaveis.containsKey(token);
    }

    private double executarOperacao(String operador, double operando1, double operando2) {
        switch (operador) {
            case "+":
                return operando1 + operando2;
            case "-":
                return operando1 - operando2;
            case "*":
                return operando1 * operando2;
            case "/":
                return operando1 / operando2;
            case "^":
                return Math.pow(operando1, operando2);
            case "log":
                return Math.log(operando2) / Math.log(operando1);
            case "sin":
                return Math.sin(Math.toRadians(operando2));
            case "cos":
                return Math.cos(Math.toRadians(operando2));
            case "tan":
                return Math.tan(Math.toRadians(operando2));
            case "exp":
                return Math.exp(operando2);
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }
}
