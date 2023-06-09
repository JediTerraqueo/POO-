package com.mycompany.restaurante_java_observer;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private App app;
    private JTabbedPane tabbedPane;
    private PedidoDialog pedidoDialog;
    private PedidosPanel pedidosPanel;

    public TelaPrincipal(App app) {
        this.app = app;

        setTitle("Restaurante - Pedidos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Criação das abas
        tabbedPane = new JTabbedPane();

        pedidoDialog = new PedidoDialog(app);
        tabbedPane.addTab("Criar Pedido", pedidoDialog);

        pedidosPanel = new PedidosPanel(app);
        tabbedPane.addTab("Listar Pedidos", pedidosPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }
}
