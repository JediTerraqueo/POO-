package com.jedilab.blog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private String titulo;
    private Usuario autor;
    private LocalDate data;
    private String texto;
    private List<Comentario> comentarios;

    public Post(String titulo, String texto, Usuario autor, Date date) {
        this.titulo = titulo;
        this.autor = autor;
        this.data = LocalDate.now();
        this.texto = texto;
        this.comentarios = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getTexto() {
        return texto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }
}