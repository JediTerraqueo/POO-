package com.jedilab.blog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogGUI extends JFrame {
    private List<Post> posts = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private JTextArea textArea;

    public BlogGUI() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Blog");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem novoPostItem = new JMenuItem("Novo Post");
        JMenuItem comentarItem = new JMenuItem("Comentar em um Post");
        JMenuItem exibirPostItem = new JMenuItem("Exibir um Post");
        JMenuItem novoUsuarioItem = new JMenuItem("Novo Usuário");
        JMenuItem sairItem = new JMenuItem("Sair");

        novoPostItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarNovoPost();
            }
        });

        comentarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comentarPost();
            }
        });

        exibirPostItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPost();
            }
        });

        novoUsuarioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarNovoUsuario();
            }
        });

        sairItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(novoPostItem);
        menu.add(comentarItem);
        menu.add(exibirPostItem);
        menu.add(novoUsuarioItem);
        menu.addSeparator();
        menu.add(sairItem);
        menuBar.add(menu);

        panel.add(menuBar, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    private void criarNovoPost() {
        String titulo = JOptionPane.showInputDialog("Título do post:");
        String conteudo = JOptionPane.showInputDialog("Conteúdo do post:");
        String[] usuariosArray = usuarios.stream().map(Usuario::getNome).toArray(String[]::new);
        String autor = (String) JOptionPane.showInputDialog(null, "Selecione o autor do post:",
                "Selecionar Autor", JOptionPane.QUESTION_MESSAGE, null, usuariosArray, usuariosArray[0]);

        Usuario autorSelecionado = usuarios.get(usuariosArray.length - 1);
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(autor)) {
                autorSelecionado = usuario;
                break;
            }
        }

        Post post = new Post(titulo, conteudo, autorSelecionado, new Date());
        posts.add(post);

        atualizarTextArea("Novo post criado com sucesso!");
    }

    private void comentarPost() {
        if (posts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há posts disponíveis para comentar.");
            return;
        }

        String[] titulosPosts = posts.stream().map(Post::getTitulo).toArray(String[]::new);
        String tituloPost = (String) JOptionPane.showInputDialog(null, "Selecione o post para comentar:",
                "Selecionar Post", JOptionPane.QUESTION_MESSAGE, null, titulosPosts, titulosPosts[0]);

        Post postSelecionado = null;
        for (Post post : posts) {
            if (post.getTitulo().equals(tituloPost)) {
                postSelecionado = post;
                break;
            }
        }

        if (postSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Post selecionado não encontrado.");
            return;
        }

        String comentario = JOptionPane.showInputDialog("Digite o comentário:");
        String[] usuariosArray = usuarios.stream().map(Usuario::getNome).toArray(String[]::new);
        String autor = (String) JOptionPane.showInputDialog(null, "Selecione o autor do comentário:",
                "Selecionar Autor", JOptionPane.QUESTION_MESSAGE, null, usuariosArray, usuariosArray[0]);

        Usuario autorSelecionado = usuarios.get(usuariosArray.length - 1);
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(autor)) {
                autorSelecionado = usuario;
                break;
            }
        }

        Comentario novoComentario = new Comentario(comentario, autorSelecionado, new Date());
        postSelecionado.adicionarComentario(novoComentario);

        atualizarTextArea("Comentário adicionado com sucesso!");
    }

    private void exibirPost() {
        if (posts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há posts disponíveis.");
            return;
        }

        String[] titulosPosts = posts.stream().map(Post::getTitulo).toArray(String[]::new);
        String tituloPost = (String) JOptionPane.showInputDialog(null, "Selecione o post para exibir:",
                "Selecionar Post", JOptionPane.QUESTION_MESSAGE, null, titulosPosts, titulosPosts[0]);

        Post postSelecionado = null;
        for (Post post : posts) {
            if (post.getTitulo().equals(tituloPost)) {
                postSelecionado = post;
                break;
            }
        }

        if (postSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Post selecionado não encontrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(postSelecionado.getTitulo()).append("\n");
        sb.append("Autor: ").append(postSelecionado.getAutor().getNome()).append("\n");
        sb.append("Data de postagem: ").append(postSelecionado.getData()).append("\n");
        sb.append("Conteúdo:\n").append(postSelecionado.getConteudo()).append("\n");

        List<Comentario> comentarios = postSelecionado.getComentarios();
        if (comentarios.isEmpty()) {
            sb.append("Não há comentários para este post.");
        } else {
            sb.append("Comentários:\n");
            for (Comentario comentario : comentarios) {
                sb.append("Autor: ").append(comentario.getAutor().getNome()).append("\n");
                sb.append("Data de comentário: ").append(comentario.getData()).append("\n");
                sb.append("Texto: ").append(comentario.getTexto()).append("\n\n");
            }
    }
   }
    private void criarNovoUsuario() {
        String nomeUsuario = JOptionPane.showInputDialog("Digite o nome do usuário:");
        Usuario novoUsuario = new Usuario(nomeUsuario);
        usuarios.add(novoUsuario);
        atualizarTextArea("Novo usuário criado com sucesso!");
    }

    private void atualizarTextArea(String texto) {
        textArea.setText(texto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BlogGUI().setVisible(true);
            }
        });
    }
}

class Usuario {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Post {
    private final String titulo;
    private final String conteudo;
    private final Usuario autor;
    private final Date data;
    private final List<Comentario> comentarios;

    public Post(String titulo, String conteudo, Usuario autor, Date data) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.data = data;
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

    public Date getData() {
        return data;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }
}

class Comentario {
    private final String texto;
    private final Usuario autor;
    private final Date data;

    public Comentario(String texto, Usuario autor, Date data) {
        this.texto = texto;
        this.autor = autor;
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Date getData() {
        return data;
    }
}
