package com.mycompany.restaurante_java_observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PedidosPanel extends JPanel implements ActionListener {
    private App app;
    private JTextArea pedidosTextArea;
    private int numero;
    private ArrayList<Item> itens;
    
    public PedidosPanel(App app) {
        this.app = app;
        this.numero = numero;
        this.itens = new ArrayList<>();

        setLayout(new BorderLayout());

        pedidosTextArea = new JTextArea();
        pedidosTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(pedidosTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton listarPedidosButton = new JButton("Listar Pedidos");
        listarPedidosButton.addActionListener(this);
        add(listarPedidosButton, BorderLayout.SOUTH);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            listarPedidos();
        }
    }

    private void listarPedidos() {
        app.salvarPedidos("src\\main\\java\\com\\mycompany\\restaurante_java_observer\\Pedidos.txt");
        ArrayList<Pedido> pedidos = (ArrayList<Pedido>) app.getPedidos();
        StringBuilder sb = new StringBuilder();

        for (Pedido pedido : pedidos) {
            sb.append("Número do Pedido: ").append(pedido.getNumero()).append("\n");
            sb.append("Pratos:\n"); 
            ArrayList<Item> itens = (ArrayList<Item>) pedido.getItens();
            for (Item item : itens) {
                Prato prato = item.getPrato();
                int quantidade = item.getQuantidade();
                sb.append("- ").append(prato.getNome()).append(" (").append(prato.getPreco()).append(") x ").append(quantidade).append("\n");
            }
            
            sb.append("\n");
            sb.append("Valor total do pedido: ").append(pedido.calcularValorTotal());
            
        }
        
        pedidosTextArea.setText(sb.toString());
    }
}
