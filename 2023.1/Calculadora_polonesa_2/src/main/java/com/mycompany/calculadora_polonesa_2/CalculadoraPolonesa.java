package com.mycompany.calculadora_polonesa_2;

import java.util.*;

// Classe da calculadora polonesa reversa
class CalculadoraPolonesa {
    private Map<String, Operacao> operacoes;
    private Map<String, Double> variaveis;

    public CalculadoraPolonesa() {
        operacoes = new HashMap<>();
        variaveis = new HashMap<>();
        configurarOperacoes();
    }

    private void configurarOperacoes() {
        operacoes.put("+", new Soma());
        operacoes.put("-", new Subtracao());
        operacoes.put("*", new Multiplicacao());
        operacoes.put("/", new Divisao());
    }

    public void adicionarOperacao(String simbolo, Operacao operacao) {
        operacoes.put(simbolo, operacao);
    }

    public double calcularExpressao(String expressao) {
        Stack<Double> pilha = new Stack<>();

        String[] elementos = expressao.split(" ");
        for (String elemento : elementos) {
            if (operacoes.containsKey(elemento)) {
                Operacao operacao = operacoes.get(elemento);
                double resultado = operacao.calcular(pilha);
                pilha.push(resultado);
            } else if (variaveis.containsKey(elemento)) {
                double valorVariavel = variaveis.get(elemento);
                pilha.push(valorVariavel);
            } else {
                try {
                    double numero = Double.parseDouble(elemento);
                    pilha.push(numero);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Elemento inválido: " + elemento);
                }
            }
        }

        if (pilha.size() != 1) {
            throw new IllegalArgumentException("Expressão inválida");
        }

        return pilha.pop();
    }

    public void setVariavel(String nome, double valor) {
        variaveis.put(nome, valor);
    }

    public double getVariavel(String nome) {
        if (variaveis.containsKey(nome)) {
            return variaveis.get(nome);
        } else {
            throw new IllegalArgumentException("Variável não existe: " + nome);
        }
    }

    public List<String> getVariaveisDisponiveis() {
        return new ArrayList<>(variaveis.keySet());
    }
}
