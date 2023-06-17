package com.mycompany.mavenproject3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PolishCalculator extends JFrame {
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton clearButton;
    private JButton calculateButton;
    private JButton setVariableButton;

    private Map<String, Integer> variables;

    public PolishCalculator() {
        setTitle("Calculadora Polonesa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Campo de texto para entrada
        inputField = new JTextField();
        inputField.setEditable(false);
        add(inputField, BorderLayout.NORTH);

        // Painel para os botões de números
        JPanel numbersPanel = new JPanel(new GridLayout(4, 3));
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numbersPanel.add(numberButtons[i]);
        }
        add(numbersPanel, BorderLayout.CENTER);

        // Painel para os botões de operadores
        JPanel operatorsPanel = new JPanel(new GridLayout(4, 1));
        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            operatorsPanel.add(operatorButtons[i]);
        }
        add(operatorsPanel, BorderLayout.EAST);

        // Painel para os botões de limpar e calcular
        JPanel controlPanel = new JPanel(new GridLayout(3, 1));
        clearButton = new JButton("Limpar");
        controlPanel.add(clearButton);
        calculateButton = new JButton("Calcular");
        controlPanel.add(calculateButton);
        setVariableButton = new JButton("Definir Variável");
        controlPanel.add(setVariableButton);
        add(controlPanel, BorderLayout.SOUTH);

        // Mapa para armazenar as variáveis
        variables = new HashMap<>();

        // Adicionar listeners aos botões
        for (int i = 0; i < 10; i++) {
            final int number = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    inputField.setText(inputField.getText() + number);
                }
            });
        }

        for (int i = 0; i < 4; i++) {
            final String operator = operatorButtons[i].getText();
            operatorButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    inputField.setText(inputField.getText() + " " + operator);
                }
            });
        }

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String expression = inputField.getText();
                String[] tokens = expression.split("\\s+");
                Stack<Integer> stack = new Stack<>();

                for (String token : tokens) {
                    if (isOperator(token)) {
                        int b = stack.pop();
                        int a = stack.pop();
                        int result = calculate(a, b, token);
                        stack.push(result);
                    } else if (isVariable(token)) {
                        int value = getVariableValue(token);
                        stack.push(value);
                    } else {
                        int number = Integer.parseInt(token);
                        stack.push(number);
                    }
                }

                if (!stack.isEmpty()) {
                    int result = stack.pop();
                    inputField.setText(String.valueOf(result));
                }
            }
        });

        setVariableButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Digite o nome da variável:");
                if (input != null) {
                    String variableName = input.trim();
                    String valueInput = JOptionPane.showInputDialog("Digite o valor da variável:");
                    if (valueInput != null) {
                        int value = Integer.parseInt(valueInput.trim());
                        setVariable(variableName, value);
                    }
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean isVariable(String token) {
        return token.startsWith("_");
    }

    private int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }

    private void setVariable(String variableName, int value) {
        variables.put(variableName, value);
    }

    private int getVariableValue(String variableName) {
        return variables.get(variableName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PolishCalculator().setVisible(true);
            }
        });
    }
}