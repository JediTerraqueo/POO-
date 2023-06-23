package com.mycompany.calculadora_polonesa_2;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VariaveisComboBox extends JComboBox<String> {
    public VariaveisComboBox(List<Variavel> variaveis) {
        addItem("Selecione uma variável");
        for (Variavel variavel : variaveis) {
            addItem(variavel.getNome());
        }
    }
}
