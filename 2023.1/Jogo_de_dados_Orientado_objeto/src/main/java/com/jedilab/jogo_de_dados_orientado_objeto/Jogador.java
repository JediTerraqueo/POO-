package com.jedilab.jogo_de_dados_orientado_objeto;

public class Jogador extends Pessoa {
    private int ponto;

    public Jogador(String nome) {
        super(nome);
    }

    public int getPonto() {
        return ponto;
    }

    public void setPonto(int ponto) {
        this.ponto = ponto;
    }
}
