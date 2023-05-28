package com.jedilab.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comentario {
    private Usuario autor;
    private String texto;
    private List<Integer> pontuacoes;
    private double pontuacao;
    
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
    
    public List<Integer> getPontuacoes() {
        return this.pontuacoes;
    }

    public void adicionarPontuacao(int pontuacao) {
        this.getPontuacoes().add(pontuacao) ;
    }

    private double getPontuacaoMedia() {
        double totalPontuacao = 0;
        double pontuacao_media = 0;
        
        if (pontuacoes.isEmpty()) {
            return 0;
        }
        
        for (int pontos : pontuacoes) {
            totalPontuacao += pontos;
        }
        
        pontuacao_media = totalPontuacao / pontuacoes.size();        
        return pontuacao_media;
    }
    
    public double getPontuacao() {
       return this.getPontuacaoMedia();
    }
}