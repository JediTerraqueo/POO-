package com.mycompany.calculadora_polonesa_2;

import java.util.List;

// Classe fachada da calculadora
class CalculadoraFacade {
    private CalculadoraPolonesa calculadora;

    public CalculadoraFacade() {
        calculadora = new CalculadoraPolonesa();
    }

    public double calcularExpressao(String expressao) {
        return calculadora.calcularExpressao(expressao);
    }

    public void setVariavel(String nome, double valor) {
        calculadora.setVariavel(nome, valor);
    }

    public double getVariavel(String nome) {
        return calculadora.getVariavel(nome);
    }

    public List<String> getVariaveisDisponiveis() {
        return calculadora.getVariaveisDisponiveis();
    }
}
