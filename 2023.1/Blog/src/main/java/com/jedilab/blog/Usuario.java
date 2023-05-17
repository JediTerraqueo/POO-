package com.jedilab.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Comentario> comentarios;

    public Usuario(String nome) {
        this.nome = nome;
        this.comentarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void comentarPost(Post post, String texto) {
        Comentario comentario = new Comentario(texto, this, new Date());
        post.adicionarComentario(comentario);
        comentarios.add(comentario);
    }

    public void pontuarComentario(Comentario comentario, int pontuacao) {
        comentario.adicionarPontuacao(pontuacao);
    }

    public int getTotalComentarios() {
        return comentarios.size();
    }

    public double getPontuacaoMediaComentarios() {
        if (comentarios.isEmpty()) {
            return 0;
        }

        int totalPontuacao = 0;
        for (Comentario comentario : comentarios) {
            totalPontuacao += comentario.getPontuacao();
        }

        return (double) totalPontuacao / comentarios.size();
    }
}
