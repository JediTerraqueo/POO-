package com.jedilab.jogo_de_dados_orientado_objeto;

import java.util.Scanner;

public class Partida {
    private Jogador jogador1;
    private Jogador jogador2;

    public Partida(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public Jogador jogar() {
        System.out.println("===== Nova Partida =====");

        int numeroRodada = 1;
        while (true) {
            Rodada rodada = new Rodada(jogador1, jogador2, numeroRodada);
            rodada.jogar();

            if (rodada.getVencedor() != null) {
                return rodada.getVencedor();
            }

            numeroRodada++;
        }
    }
}
