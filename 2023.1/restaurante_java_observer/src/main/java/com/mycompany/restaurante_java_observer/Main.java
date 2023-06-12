package com.mycompany.restaurante_java_observer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        // Carregar os pratos do arquivo (pratos.txt)
        app.carregarPratos("src\\main\\java\\com\\mycompany\\restaurante_java_observer\\Pratos.txt");

        // Criar a janela principal
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal(app);
            telaPrincipal.setVisible(true);
        });  
    }
}
