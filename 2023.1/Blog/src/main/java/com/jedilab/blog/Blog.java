package com.jedilab.blog;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private List<Post> posts;
    private List<Usuario> usuarios;

    public Blog() {
        this.posts = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarPost(Post post) {
        posts.add(post);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public int getTotalPosts() {
        return posts.size();
    }

    public int getTotalUsuarios() {
        return usuarios.size();
    }

    public double getMediaComentariosPorPost() {
        if (posts.isEmpty()) {
            return 0;
        }

        int totalComentarios = 0;
        for (Post post : posts) {
            totalComentarios += post.getComentarios().size();
        }

        return (double) totalComentarios / posts.size();
    }
}