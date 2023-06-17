package com.mycompany.restaurante_java_observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PedidoDialog extends JPanel implements ActionListener {
    private App app;
    private List<Prato> pratosDisponiveis;
    private List<JComboBox<Prato>> comboPratos;
    private List<JSpinner> spinnerQuantidades;
    private JButton adicionarPratoButton;
    private JButton criarPedidoButton;
    private JButton limparButton;

    public PedidoDialog(App app) {
        this.app = app;
        pratosDisponiveis = app.getPratos();
        comboPratos = new ArrayList<>();
        spinnerQuantidades = new ArrayList<>();

        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        JLabel labelTitulo = new JLabel("Criar Pedido");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(labelTitulo, c);

        int row = 1;
        for (int i = 0; i < 5; i++) {
            JComboBox<Prato> comboPrato = new JComboBox<>(pratosDisponiveis.toArray(new Prato[0]));
            comboPratos.add(comboPrato);
            c.gridx = 0;
            c.gridy = row;
            c.gridwidth = 1;
            panel.add(comboPrato, c);

            JSpinner spinnerQuantidade = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
            spinnerQuantidades.add(spinnerQuantidade);
            c.gridx = 1;
            c.gridy = row;
            c.gridwidth = 1;
            panel.add(spinnerQuantidade, c);

            row++;
        }

        adicionarPratoButton = new JButton("Adicionar Prato");
        adicionarPratoButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = row;
        c.gridwidth = 2;
        panel.add(adicionarPratoButton, c);

        criarPedidoButton = new JButton("Criar Pedido");
        criarPedidoButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = row + 1;
        c.gridwidth = 2;
        panel.add(criarPedidoButton, c);

        limparButton = new JButton("Limpar");
        limparButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = row + 2;
        c.gridwidth = 2;
        panel.add(limparButton, c);

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adicionarPratoButton) {
            if (comboPratos.size() < 5) {
                JComboBox<Prato> comboPrato = new JComboBox<>(pratosDisponiveis.toArray(new Prato[0]));
                comboPratos.add(comboPrato);
                spinnerQuantidades.add(new JSpinner(new SpinnerNumberModel(1, 1, 99, 1)));

                remove(adicionarPratoButton);
                remove(criarPedidoButton);
                remove(limparButton);

                JPanel panel = (JPanel) getComponent(0);
                GridBagConstraints c = ((GridBagLayout) panel.getLayout()).getConstraints(adicionarPratoButton);
                int row = c.gridy;
                c.gridx = 0;
                c.gridy = row + 1;
                c.gridwidth = 1;
                panel.add(comboPrato, c);

                c.gridx = 1;
                panel.add(spinnerQuantidades.get(comboPratos.size() - 1), c);

                c.gridx = 0;
                c.gridy = row + 2;
                c.gridwidth = 2;
                panel.add(adicionarPratoButton, c);
                panel.add(criarPedidoButton, c);
                panel.add(limparButton, c);

                revalidate();
                repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Limite máximo de pratos atingido.");
            }
        } else if (e.getSource() == criarPedidoButton) {
            Pedido pedido = app.criarPedido();

            for (int i = 0; i < comboPratos.size(); i++) {
                JComboBox<Prato> comboPrato = comboPratos.get(i);
                JSpinner spinnerQuantidade = spinnerQuantidades.get(i);

                Prato prato = (Prato) comboPrato.getSelectedItem();
                int quantidade = (int) spinnerQuantidade.getValue();

                Item item = new Item(prato, quantidade);
                pedido.adicionarItem(item);
            }

            JOptionPane.showMessageDialog(this, "Pedido criado com sucesso! Número do Pedido: " + pedido.getNumero());
            limparCampos();
        } else if (e.getSource() == limparButton) {
            limparCampos();
        }
    }

    private void limparCampos() {
        comboPratos.clear();
        spinnerQuantidades.clear();

        removeAll();
        add(new PedidoDialog(app), BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}
