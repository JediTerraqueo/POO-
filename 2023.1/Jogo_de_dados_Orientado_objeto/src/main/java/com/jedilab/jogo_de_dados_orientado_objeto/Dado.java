package com.jedilab.jogo_de_dados_orientado_objeto;

import java.util.Random;

public class Dado {
    private int valor;

    public int jogar() {
        Random random = new Random();
        valor = random.nextInt(6) + 1;
        return valor;
    }

    public int getValor() {
        return valor;
    }
}
