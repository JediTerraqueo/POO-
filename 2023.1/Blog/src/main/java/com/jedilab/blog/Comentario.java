package com.jedilab.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comentario {
    private Usuario autor;
    private String texto;
    private List<Integer> pontuacoes;

    public Comentario(String texto, Usuario autor, Date date) {
        this.autor = autor;
        this.texto = texto;
        this.pontuacoes = new ArrayList<>();
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }

    public void adicionarPontuacao(int pontuacao) {
        pontuacoes.add(pontuacao);
    }

    public double getPontuacaoMedia() {
        if (pontuacoes.isEmpty()) {
            return 0;
        }

        int totalPontuacao = 0;
        for (int pontuacao : pontuacoes) {
            totalPontuacao += pontuacao;
        }

        return (double) totalPontuacao / pontuacoes.size();
    }

    public int getPontuacao() {
        if (pontuacoes.isEmpty()) {
            return 0;
        }

        int totalPontuacao = 0;
        for (int pontuacao : pontuacoes) {
            totalPontuacao += pontuacao;
        }

        return totalPontuacao;
    }
}
