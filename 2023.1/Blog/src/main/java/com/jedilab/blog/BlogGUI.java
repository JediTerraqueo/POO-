package com.jedilab.blog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogGUI extends javax.swing.JFrame {

    private List<Post> posts;
    private List<Usuario> usuarios;
    private Timer timer;

    public BlogGUI() {
        initComponents();
        posts = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    private void initComponents() {
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelPosts = new javax.swing.JPanel();
        jButtonCriarPost = new javax.swing.JButton();
        jScrollPanePosts = new javax.swing.JScrollPane();
        textAreaPosts = new javax.swing.JTextArea();
        jButtonComentarPost = new javax.swing.JButton();
        jPanelUsers = new javax.swing.JPanel();
        jButtonCriarUsuario = new javax.swing.JButton();
        jScrollPaneUsers = new javax.swing.JScrollPane();
        textAreaUsers = new javax.swing.JTextArea();
        jButtonPontuarComentario = new javax.swing.JButton();
        
        timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            atualizarInformacoes();
            }
        });
        timer.start();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blog");

        jButtonCriarPost.setText("Criar Post");
        jButtonCriarPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCriarPostActionPerformed(evt);
            }
        });

        textAreaPosts.setEditable(false);
        textAreaPosts.setColumns(20);
        textAreaPosts.setRows(5);
        jScrollPanePosts.setViewportView(textAreaPosts);

        jButtonComentarPost.setText("Comentar Post");
        jButtonComentarPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonComentarPostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPostsLayout = new javax.swing.GroupLayout(jPanelPosts);
        jPanelPosts.setLayout(jPanelPostsLayout);
        jPanelPostsLayout.setHorizontalGroup(
            jPanelPostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPostsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanePosts, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(jPanelPostsLayout.createSequentialGroup()
                        .addComponent(jButtonCriarPost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonComentarPost)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelPostsLayout.setVerticalGroup(
            jPanelPostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPostsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCriarPost)
                    .addComponent(jButtonComentarPost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanePosts, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Posts", jPanelPosts);

        jButtonCriarUsuario.setText("Criar Usuário");
        jButtonCriarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCriarUsuarioActionPerformed(evt);
            }
        });

        textAreaUsers.setEditable(false);
        textAreaUsers.setColumns(20);
        textAreaUsers.setRows(5);
        jScrollPaneUsers.setViewportView(textAreaUsers);

        jButtonPontuarComentario.setText("Pontuar Comentário");
        jButtonPontuarComentario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonPontuarComentarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsersLayout = new javax.swing.GroupLayout(jPanelUsers);
        jPanelUsers.setLayout(jPanelUsersLayout);
        jPanelUsersLayout.setHorizontalGroup(
            jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(jPanelUsersLayout.createSequentialGroup()
                        .addComponent(jButtonCriarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPontuarComentario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelUsersLayout.setVerticalGroup(
            jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCriarUsuario)
                    .addComponent(jButtonPontuarComentario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Users", jPanelUsers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        pack();
    }
    
    private void atualizarInformacoes() {
        exibirPosts();
        exibirUsuarios();
    }
    
    private void jButtonCriarPostActionPerformed(ActionEvent evt) {
        String titulo = JOptionPane.showInputDialog(this, "Digite o título do post:");
        if (titulo != null && !titulo.isEmpty()) {
            String texto = JOptionPane.showInputDialog(this, "Digite o texto do post:");
            if (texto != null && !texto.isEmpty()) {
                Usuario autor = selecionarUsuario();
                if (autor != null) {
                    Post post = new Post(titulo, texto, autor, new Date());
                    posts.add(post);
                    exibirPosts();
                }
            }
        }
    }

    private void jButtonComentarPostActionPerformed(ActionEvent evt) {
        Post postSelecionado = selecionarPost();
        if (postSelecionado != null) {
            String texto = JOptionPane.showInputDialog(this, "Digite o comentário:");
            if (texto != null && !texto.isEmpty()) {
                Usuario autor = selecionarUsuario();
                if (autor != null) {
                    Comentario comentario = new Comentario(texto, autor, new Date());
                    postSelecionado.adicionarComentario(comentario);
                    exibirPosts();
                }
            }
        }
    }

    private void jButtonCriarUsuarioActionPerformed(ActionEvent evt) {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do usuário:");
        if (nome != null && !nome.isEmpty()) {
            Usuario usuario = new Usuario(nome);
            usuario.setPosts(posts); // Configura a lista de posts para o usuário
            usuarios.add(usuario);
            exibirUsuarios();
    }
}

    private void jButtonPontuarComentarioActionPerformed(ActionEvent evt) {
        Comentario comentarioSelecionado = selecionarComentario();
        if (comentarioSelecionado != null) {
            Usuario pontuador = selecionarUsuario();
            if (pontuador != null) {
                int pontuacao = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite a pontuação (0 a 5):"));
                if (pontuacao >= 0 && pontuacao <= 5) {
                    comentarioSelecionado.adicionarPontuacao(pontuacao); // Atualiza a pontuação do comentário
                    exibirPosts(); // Atualiza a exibição dos posts na tela
                } else {
                    JOptionPane.showMessageDialog(this, "Pontuação inválida! A pontuação deve ser entre 0 e 5.");
            }
        }
    }
}
    private Usuario selecionarUsuario() {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há usuários cadastrados.");
            return null;
        }

        String[] opcoes = new String[usuarios.size()];
        for (int i = 0; i < usuarios.size(); i++) {
            opcoes[i] = usuarios.get(i).getNome();
        }

        String usuarioSelecionado = (String) JOptionPane.showInputDialog(this, "Selecione o usuário:", "Selecionar Usuário",
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (usuarioSelecionado != null) {
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equals(usuarioSelecionado)) {
                    return usuario;
                }
            }
        }

        return null;
    }

    private Post selecionarPost() {
        if (posts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há posts disponíveis.");
            return null;
        }

        String[] opcoes = new String[posts.size()];
        for (int i = 0; i < posts.size(); i++) {
            opcoes[i] = posts.get(i).getTitulo();
        }

        String postSelecionado = (String) JOptionPane.showInputDialog(this, "Selecione o post:", "Selecionar Post",
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (postSelecionado != null) {
            for (Post post : posts) {
                if (post.getTitulo().equals(postSelecionado)) {
                    return post;
                }
            }
        }

        return null;
    }

    private Comentario selecionarComentario() {
        List<Comentario> comentarios = new ArrayList<>();
        for (Post post : posts) {
            comentarios.addAll(post.getComentarios());
        }

        if (comentarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há comentários disponíveis.");
            return null;
        }

        String[] opcoes = new String[comentarios.size()];
        for (int i = 0; i < comentarios.size(); i++) {
            opcoes[i] = comentarios.get(i).getTexto();
        }

        String comentarioSelecionado = (String) JOptionPane.showInputDialog(this, "Selecione o comentário:", "Selecionar Comentário",
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (comentarioSelecionado != null) {
            for (Comentario comentario : comentarios) {
                if (comentario.getTexto().equals(comentarioSelecionado)) {
                    return comentario;
                }
            }
        }

        return null;
    }

    private void exibirPosts() {
        textAreaPosts.setText("");
        for (Post post : posts) {
            textAreaPosts.append("Título: " + post.getTitulo() + "\n");
            textAreaPosts.append("Autor: " + post.getAutor().getNome() + "\n");
            textAreaPosts.append("Data: " + post.getData() + "\n");
            textAreaPosts.append("Texto: " + post.getTexto() + "\n\n");
            textAreaPosts.append("Comentários:\n");
            for (Comentario comentario : post.getComentarios()) {
                textAreaPosts.append("- " + comentario.getAutor().getNome() + ": " + comentario.getTexto() + "\n");
                textAreaPosts.append("   Pontuação: " + comentario.getPontuacao() + "\n\n");
            }
            textAreaPosts.append("-----------------------\n");
        }
    }

    private void exibirUsuarios() {
    textAreaUsers.setText("");
    for (Usuario usuario : usuarios) {
        textAreaUsers.append("Nome: " + usuario.getNome() + "\n");
        
        // Verificar se a lista de comentários não é nula
        if (usuario.getComentarios() != null) {
            textAreaUsers.append("Total de comentários: " + usuario.getTotalComentarios() + "\n");
            textAreaUsers.append("Pontuação média dos comentários: " + usuario.getPontuacaoMediaComentarios()+ "\n\n");
        } else {
            textAreaUsers.append("Total de comentários: 0\n");
            textAreaUsers.append("Pontuação média dos comentários: 0.0\n\n");
        }
    }
}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlogGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonComentarPost;
    private javax.swing.JButton jButtonCriarPost;
    private javax.swing.JButton jButtonCriarUsuario;
    private javax.swing.JButton jButtonPontuarComentario;
    private javax.swing.JPanel jPanelPosts;
    private javax.swing.JPanel jPanelUsers;
    private javax.swing.JScrollPane jScrollPanePosts;
    private javax.swing.JScrollPane jScrollPaneUsers;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextArea textAreaPosts;
    private javax.swing.JTextArea textAreaUsers;
}