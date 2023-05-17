package com.mycompany.busca_vetorial;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    private final Buscador<Documento> buscador;
    private final JTextArea textArea;

    public Main() {
        buscador = new Buscador<>();
        textArea = new JTextArea();
        textArea.setEditable(false);
    }

    public void run() {
        SwingUtilities.invokeLater(() -> {
            // Criação do frame principal
            JFrame frame = new JFrame("Menu Buscador de Documentos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Painel principal
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            // Rótulo de boas-vindas
            JLabel label = new JLabel("Bem-vindo ao Buscador de Documentos!");
            panel.add(label, BorderLayout.NORTH);

            // Botões
            JButton adicionarButton = new JButton("Adicionar Documento");
            JButton buscarButton = new JButton("Buscar Documento");
            JButton listarButton = new JButton("Listar Documentos");
            JButton sairButton = new JButton("Sair");

            // Área de texto para exibir os documentos adicionados
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(300, 200));
            panel.add(scrollPane, BorderLayout.CENTER);

            // Ação do botão "Adicionar Documento"
            adicionarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String conteudo = JOptionPane.showInputDialog(frame, "Digite o conteúdo do documento:");
                    Documento documento = new Documento(conteudo);
                    buscador.adicionarObjeto(documento);
                    textArea.append("Documento adicionado: " + conteudo + "\n");
                }
            });

            // Ação do botão "Buscar Documento"
            buscarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String termoBusca = JOptionPane.showInputDialog(frame, "Digite o termo de busca:");
                    List<Documento> resultados = buscador.buscar(documento -> documento.contemPalavra(termoBusca));
                    if (resultados.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Nenhum resultado encontrado para o termo: " + termoBusca);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Resultados para o termo: ").append(termoBusca).append("\n");
                        for (Documento resultado : resultados) {
                            sb.append(resultado.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(frame, sb.toString());
                    }
                }
            });

            // Ação do botão "Listar Documentos"
            listarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    List<Documento> documentos = buscador.getObjetos();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Documentos existentes:\n");
                    for (Documento documento : documentos) {
                        sb.append(documento.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(frame, sb.toString());
                }
            });

            // Ação do botão "Sair"
            sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            }
     
            });
                   
            // Adiciona os botões ao painel principal
            panel.add(adicionarButton, BorderLayout.WEST);
            panel.add(buscarButton, BorderLayout.CENTER);
            panel.add(listarButton, BorderLayout.EAST);
            panel.add(sairButton, BorderLayout.SOUTH);

        // Adiciona o painel principal ao frame
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    });
}

public static void main(String[] args) {
    Main main = new Main();
    main.run();
}
}

