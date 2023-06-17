package com.mycompany.mavenproject2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class App extends Observable {
    private ArrayList<Prato> pratos;
    private ArrayList<Pedido> pedidos;

    public App() {
        pratos = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public static void main(String[] args) {
        App app = new App();
        TelaPrincipal telaPrincipal = new TelaPrincipal(app);
        app.addObserver(telaPrincipal);
        telaPrincipal.exibir();
    }
}

class Prato {
    private String nome;
    private String descricao;
    private double preco;

    public Prato(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
}

class Pedido {
    private int numero;
    private ArrayList<Item> itens;

    public Pedido(int numero) {
        this.numero = numero;
        itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Prato prato, int quantidade) {
        Item item = new Item(prato, quantidade);
        itens.add(item);
    }
}

class Item {
    private Prato prato;
    private int quantidade;

    public Item(Prato prato, int quantidade) {
        this.prato = prato;
        this.quantidade = quantidade;
    }

    public Prato getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

class TelaPrincipal extends JFrame implements Observer {
    private App app;
    private JTextArea pedidosTextArea;
    private JComboBox<Prato> pratosComboBox;
    private JTextField quantidadeTextField;

    public TelaPrincipal(App app) {
        this.app = app;
        setTitle("Restaurante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        pedidosTextArea = new JTextArea();
        pedidosTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(pedidosTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel criarPedidoPanel = new JPanel();
        criarPedidoPanel.setLayout(new FlowLayout());

        JLabel pratoLabel = new JLabel("Prato:");
        criarPedidoPanel.add(pratoLabel);

        pratosComboBox = new JComboBox<>();
        criarPedidoPanel.add(pratosComboBox);

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        criarPedidoPanel.add(quantidadeLabel);

        quantidadeTextField = new JTextField(10);
        criarPedidoPanel.add(quantidadeTextField);

        JButton criarPedidoButton = new JButton("Criar Pedido");
        criarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prato pratoSelecionado = (Prato) pratosComboBox.getSelectedItem();
                int quantidade = Integer.parseInt(quantidadeTextField.getText());

                Pedido pedido = new Pedido(app.getPedidos().size() + 1);
                pedido.adicionarItem(pratoSelecionado, quantidade);
                app.adicionarPedido(pedido);

                JOptionPane.showMessageDialog(TelaPrincipal.this, "Pedido criado com sucesso!");
            }
        });
        criarPedidoPanel.add(criarPedidoButton);

        JButton listarPedidosButton = new JButton("Listar Pedidos");
        listarPedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (Pedido pedido : app.getPedidos()) {
                    sb.append("Pedido ").append(pedido.getNumero()).append(":").append("\n");
                    for (Item item : pedido.getItens()) {
                        sb.append("- Prato: ").append(item.getPrato().getNome())
                                .append(", Quantidade: ").append(item.getQuantidade())
                                .append(", Preço Unitário: ").append(item.getPrato().getPreco())
                                .append("\n");
                    }
                    sb.append("\n");
                }
                pedidosTextArea.setText(sb.toString());
            }
        });
        criarPedidoPanel.add(listarPedidosButton);

        add(criarPedidoPanel, BorderLayout.SOUTH);
    }

    public void exibir() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof App) {
            App app = (App) o;
            ArrayList<Prato> pratos = app.getPratos();
            pratosComboBox.setModel(new DefaultComboBoxModel<>(pratos.toArray(new Prato[0])));
        }
    }
}
