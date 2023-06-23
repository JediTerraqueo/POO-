package com.mycompany.calculadora_polonesa_2;

public class Variavel {
    private String nome;
    private double valor;

    public Variavel(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
