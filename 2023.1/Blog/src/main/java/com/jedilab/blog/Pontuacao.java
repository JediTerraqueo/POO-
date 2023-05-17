package com.jedilab.blog;

public class Pontuacao {

    private int pontuacao;
    private Usuario pontuador;

    public Pontuacao(int pontuacao, Usuario pontuador) {
        this.pontuacao = pontuacao;
        this.pontuador = pontuador;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Usuario getPontuador() {
        return pontuador;
    }

    @Override
    public String toString() {
        return "Pontuação: " + pontuacao + " - Pontuador: " + pontuador.getNome();
    }
}
