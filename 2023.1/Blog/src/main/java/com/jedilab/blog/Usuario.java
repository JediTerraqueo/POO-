package com.jedilab.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Comentario> comentarios;
    private List<Post> posts;
   

    
    public Usuario(String nome) {
        this.nome = nome;
        this.comentarios = new ArrayList<>();
    } 
    
    public List<Comentario> getComentarios() {
        return this.comentarios;
    }
    
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getNome() {
        return nome;
    }
    
    public void addComentario(Comentario c){
        this.getComentarios().add(c);
        
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
        int totalComentarios = 0;
        for (Post post : posts) {
            for (Comentario comentario : post.getComentarios()) {
                if (comentario.getAutor().equals(this)) {
                    totalComentarios++;
                }
            }
        }
    return totalComentarios;
    }

    public double getPontuacaoMediaComentarios() {
        double totalPontuacao = 0;
        double pontuacao_media = 0;
        
        if (comentarios.isEmpty()) {
            //int variavelQualquerAi = 0;
            return 0;
        }else{
            
        for (Comentario comentario : comentarios) {
            totalPontuacao += comentario.getPontuacao();
        }
        pontuacao_media = totalPontuacao / comentarios.size();
        
        return pontuacao_media;
        }
    }
}