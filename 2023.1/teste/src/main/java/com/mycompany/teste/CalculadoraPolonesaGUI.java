package com.mycompany.teste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;


public class CalculadoraPolonesaGUI extends JFrame {
    private JTextField display;
    private StringBuilder expressaoBuilder;

    public CalculadoraPolonesaGUI() {
        super("Calculadora Polonesa");
        expressaoBuilder = new StringBuilder();

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(display, BorderLayout.NORTH);

        JPanel tecladoPanel = criarTecladoPanel();
        contentPane.add(tecladoPanel, BorderLayout.CENTER);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularExpressao();
            }
        });
        contentPane.add(calcularButton, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarTecladoPanel() {
        JPanel tecladoPanel = new JPanel();
        tecladoPanel.setLayout(new GridLayout(4, 4));

        String[][] botoes = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", ".", "=", "+"}
        };

        for (String[] linha : botoes) {
            for (String textoBotao : linha) {
                JButton botao = new JButton(textoBotao);
                botao.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String comando = e.getActionCommand();
                        if (comando.equals("=")) {
                            calcularExpressao();
                        } else {
                            expressaoBuilder.append(comando);
                            display.setText(expressaoBuilder.toString());
                        }
                    }
                });
                tecladoPanel.add(botao);
            }
        }

        return tecladoPanel;
    }

    public class CalculadoraPolonesa {
        private Stack<Double> pilha;

        public CalculadoraPolonesa() {
            pilha = new Stack<>();
        }

        public double calcular(String expressao) {
            String[] tokens = expressao.split(" ");

            for (String token : tokens) {
                if (token.matches("-?\\d+(\\.\\d+)?")) {
                    // O token é um número
                    double numero = Double.parseDouble(token);
                    pilha.push(numero);
                } else {
                    // O token é um operador
                    if (pilha.size() < 2) {
                        throw new IllegalArgumentException("Expressão inválida");
                    }

                    double operando2 = pilha.pop();
                    double operando1 = pilha.pop();
                    double resultado = executarOperacao(token, operando1, operando2);
                    pilha.push(resultado);
                }
            }

            if (pilha.size() != 1) {
                throw new IllegalArgumentException("Expressão inválida");
            }

            return pilha.pop();
        }

        private double executarOperacao(String operador, double operando1, double operando2) {
            switch (operador) {
                case "+":
                    return operando1 + operando2;
                case "-":
                    return operando1 - operando2;
                case "*":
                    return operando1 * operando2;
                case "/":
                    if (operando2 != 0) {
                        return operando1 / operando2;
                    } else {
                        throw new ArithmeticException("Divisão por zero");
                    }
                default:
                    throw new IllegalArgumentException("Operador inválido: " + operador);
            }
        }
    }

    private void calcularExpressao() {
        String expressao = expressaoBuilder.toString();
        CalculadoraPolonesa calculadora = new CalculadoraPolonesa();
        try {
            double resultado = calculadora.calcular(expressao);
            display.setText(Double.toString(resultado));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        expressaoBuilder.setLength(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculadoraPolonesaGUI calculadoraGUI = new CalculadoraPolonesaGUI();
                calculadoraGUI.setVisible(true);
            }
        });
    }
}
