package com.jedilab.jogo_de_dados_orientado_objeto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jogador jogador1 = new Jogador("Jogador 1");
        Jogador jogador2 = new Jogador("Jogador 2");

        int numRodadas;
        do {
            System.out.print("Digite o número de rodadas (deve ser ímpar e maior que 0): ");
            numRodadas = scanner.nextInt();
        } while (numRodadas % 2 == 0 || numRodadas <= 0);

        Rodada[] rodadas = new Rodada[numRodadas];
        for (int i = 0; i < numRodadas; i++) {
            rodadas[i] = new Rodada(jogador1, jogador2, i + 1);
            rodadas[i].jogar();
        }

        int pontosJogador1 = 0;
        int pontosJogador2 = 0;
        for (Rodada rodada : rodadas) {
            Jogador vencedor = rodada.getVencedor();
            if (vencedor == jogador1) {
                pontosJogador1++;
            } else if (vencedor == jogador2) {
                pontosJogador2++;
            }
        }

        System.out.println("----- Resultado Final -----");
        System.out.println(jogador1.getNome() + ": " + pontosJogador1 + " pontos");
        System.out.println(jogador2.getNome() + ": " + pontosJogador2 + " pontos");
        if (pontosJogador1 > pontosJogador2) {
            System.out.println("Parabéns, " + jogador1.getNome() + ", você venceu!");
        } else if (pontosJogador2 > pontosJogador1) {
            System.out.println("Parabéns, " + jogador2.getNome() + ", você venceu!");
        } else {
            System.out.println("A partida terminou em empate!");
        }
    }
}
