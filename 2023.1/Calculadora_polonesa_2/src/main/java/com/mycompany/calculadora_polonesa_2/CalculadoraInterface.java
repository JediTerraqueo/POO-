package com.mycompany.calculadora_polonesa_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CalculadoraInterface {
    private JFrame frame;
    private JTextField expressaoTextField;
    private JComboBox<String> variaveisComboBox;
    private CalculadoraFacade calculadora;
    private Map<String, Double> variaveis;

    public CalculadoraInterface() {
        calculadora = new CalculadoraFacade();
        variaveis = calculadora.getVariaveis();

        criarInterface();
    }

    private void criarInterface() {
        frame = new JFrame("Calculadora Polonesa Reversa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel expressaoPanel = new JPanel(new FlowLayout());
        JLabel expressaoLabel = new JLabel("Expressão:");
        expressaoTextField = new JTextField(20);
        expressaoPanel.add(expressaoLabel);
        expressaoPanel.add(expressaoTextField);

        JPanel variaveisPanel = new JPanel(new BorderLayout());
        variaveisPanel.add(new JLabel("Variáveis:"), BorderLayout.NORTH);
        variaveisComboBox = new JComboBox<>();
        variaveisPanel.add(variaveisComboBox, BorderLayout.CENTER);

        JButton adicionarVariavelButton = new JButton("Adicionar Variável");
        adicionarVariavelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome da variável:");
                if (nome != null && !nome.isEmpty()) {
                    try {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da variável:"));
                        calculadora.adicionarVariavel(nome, valor);
                        variaveisComboBox.addItem(nome);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Valor inválido para a variável");
                    }
                }
            }
        });

        JButton limparVariaveisButton = new JButton("Limpar Variáveis");
        limparVariaveisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculadora.limparVariaveis();
                variaveisComboBox.removeAllItems();
            }
        });

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        buttonsPanel.add(adicionarVariavelButton);
        buttonsPanel.add(limparVariaveisButton);

        JPanel operacoesPanel = new JPanel(new FlowLayout());
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularExpressao();
            }
        });
        operacoesPanel.add(calcularButton);

        JPanel funcoesPanel = new JPanel(new FlowLayout());
        JTextArea funcoesTextArea = new JTextArea();
        funcoesTextArea.setEditable(false);
        funcoesTextArea.setText("Funções disponíveis:\n" +
                "- Operadores: +, -, *, /\n" +
                "- Funções Trigonométricas: sin, cos, tan\n" +
                "- Funções Logarítmicas: log, ln\n" +
                "- Função Exponencial: exp");
        funcoesPanel.add(funcoesTextArea);

        panel.add(expressaoPanel, BorderLayout.NORTH);
        panel.add(variaveisPanel, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.EAST);
        panel.add(operacoesPanel, BorderLayout.SOUTH);
        panel.add(funcoesPanel, BorderLayout.WEST);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void calcularExpressao() {
        String expressao = expressaoTextField.getText();
        try {
            double resultado = calculadora.calcularExpressao(expressao);
            JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraInterface();
            }
        });
    }
}
