package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BlogGUI extends Application {

    private List<Post> posts = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Blog");

        // Criação dos componentes da interface
        Label titleLabel = new Label("Título:");
        TextField titleTextField = new TextField();

        Label contentLabel = new Label("Conteúdo:");
        TextArea contentTextArea = new TextArea();

        Button createPostButton = new Button("Criar Post");
        createPostButton.setOnAction(event -> criarNovoPost(titleTextField.getText(), contentTextArea.getText()));

        Label selectPostLabel = new Label("Selecione o post para comentar:");
        ChoiceBox<String> postChoiceBox = new ChoiceBox<>();
        postChoiceBox.setOnAction(event -> exibirPost(postChoiceBox.getValue()));

        Label commentLabel = new Label("Digite seu comentário:");
        TextArea commentTextArea = new TextArea();

        Label selectUserLabel = new Label("Selecione o autor do comentário:");
        ChoiceBox<String> userChoiceBox = new ChoiceBox<>();
        userChoiceBox.setOnAction(event -> {
            if (postChoiceBox.getValue() != null) {
                String selectedUser = userChoiceBox.getValue();
                String selectedPost = postChoiceBox.getValue();
                adicionarComentario(selectedUser, selectedPost, commentTextArea.getText());
            }
        });

        Button commentButton = new Button("Comentar");

        textArea = new TextArea();
        textArea.setEditable(false);

        // Layouts
        VBox createPostLayout = new VBox(10, titleLabel, titleTextField, contentLabel, contentTextArea, createPostButton);
        createPostLayout.setAlignment(Pos.CENTER);
        createPostLayout.setPadding(new Insets(10));

        VBox commentLayout = new VBox(10, selectPostLabel, postChoiceBox, commentLabel, commentTextArea,
                selectUserLabel, userChoiceBox, commentButton);
        commentLayout.setAlignment(Pos.CENTER);
        commentLayout.setPadding(new Insets(10));

        VBox mainLayout = new VBox(10, createPostLayout, commentLayout, textArea);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(10));

        // Carregar usuários iniciais
        usuarios.add(new Usuario("João", "joao@example.com"));
        usuarios.add(new Usuario("Maria", "maria@example.com"));

        // Carregar posts iniciais
        posts.add(new Post("Primeiro Post", "Conteúdo do primeiro post", usuarios.get(0), LocalDateTime.now()));
        posts.add(new Post("Segundo Post", "Conteúdo do segundo post", usuarios.get(1), LocalDateTime.now()));

        // Carregar os títulos dos posts e usuários nos choice boxes
        for (Post post : posts) {
            postChoiceBox.getItems().add(post.getTitulo());
        }

        for (Usuario usuario : usuarios) {
            userChoiceBox.getItems().add(usuario.getNome());
        }

        commentButton.setOnAction(event -> {
            if (postChoiceBox.getValue() != null && userChoiceBox.getValue() != null) {
                String selectedUser = userChoiceBox.getValue();
                String selectedPost = postChoiceBox.getValue();
                adicionarComentario(selectedUser, selectedPost, commentTextArea.getText());
            }
        });

        // Configurar a cena principal
        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void criarNovoPost(String titulo, String conteudo) {
        if (!titulo.isEmpty() && !conteudo.isEmpty()) {
            Usuario autor = usuarios.get(0); // Definir o autor do post (exemplo: primeiro usuário)
            Post post = new Post(titulo, conteudo, autor, LocalDateTime.now());
            posts.add(post);
            textArea.appendText("Novo post criado:\n");
            textArea.appendText(post.toString());
            textArea.appendText("\n\n");
        }
    }

    private void exibirPost(String titulo) {
        for (Post post : posts) {
            if (post.getTitulo().equals(titulo)) {
                textArea.appendText("Post selecionado:\n");
                textArea.appendText(post.toString());
                textArea.appendText("\n\n");
                break;
            }
        }
    }

    private void adicionarComentario(String nomeUsuario, String tituloPost, String textoComentario) {
        Usuario autor = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                autor = usuario;
                break;
            }
        }

        if (autor != null) {
            for (Post post : posts) {
                if (post.getTitulo().equals(tituloPost)) {
                    Comentario comentario = new Comentario(textoComentario, autor, LocalDateTime.now());
                    post.adicionarComentario(comentario);
                    textArea.appendText("Novo comentário adicionado:\n");
                    textArea.appendText(comentario.toString());
                    textArea.appendText("\n\n");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Post {
    private String titulo;
    private String conteudo;
    private Usuario autor;
    private LocalDateTime dataPublicacao;
    private List<Comentario> comentarios;

    public Post(String titulo, String conteudo, Usuario autor, LocalDateTime dataPublicacao) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.comentarios = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
                "Autor: " + autor.getNome() + "\n" +
                "Conteúdo: " + conteudo + "\n" +
                "Data de publicação: " + dataPublicacao.toString() + "\n" +
                "Comentários: " + comentarios.size();
    }
}

class Comentario {
    private String texto;
    private Usuario autor;
    private LocalDateTime dataPublicacao;

    public Comentario(String texto, Usuario autor, LocalDateTime dataPublicacao) {
        this.texto = texto;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getAutor() {
        return autor;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public String toString() {
        return "Autor: " + autor.getNome() + "\n" +
                "Comentário: " + texto + "\n" +
                "Data de publicação: " + dataPublicacao.toString();
    }
}

class Usuario {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
