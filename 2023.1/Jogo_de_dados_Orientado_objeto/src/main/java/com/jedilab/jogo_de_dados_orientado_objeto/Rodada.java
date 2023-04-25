package com.jedilab.jogo_de_dados_orientado_objeto;

import java.util.Random;

public class Rodada {
    private Jogador jogador1;
    private Jogador jogador2;
    private int numero;
    private Jogador vencedor;

    public Rodada(Jogador jogador1, Jogador jogador2, int numero) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.numero = numero;
    }

    public void jogar() {
        System.out.println("----- Rodada " + numero + " -----");

        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        int somaDados = dado1.jogar() + dado2.jogar();

        System.out.println(jogador1.getNome() + " jogou os dados e obteve: " + dado1.getValor() + " e " + dado2.getValor());
        if (somaDados == 7 || somaDados == 11) {
            vencedor = jogador1;
            System.out.println("Parabéns, " + jogador1.getNome() + ", você venceu!");
        } else if (somaDados == 2 || somaDados == 3 || somaDados == 12) {
            vencedor = jogador2;
            System.out.println("Parabéns, " + jogador2.getNome() + ", você venceu!");
        } else {
            System.out.println("O Ponto é " + somaDados);

            while (true) {
                System.out.println(jogador2.getNome() + ", é sua vez de jogar. Pressione Enter para jogar os dados.");
                new Scanner(System.in).nextLine();

                dado1.jogar();
                dado2.jogar();
                somaDados = dado1.getValor() + dado2.getValor();

                System.out.println(jogador2.getNome() + " jogou os dados e obteve: " + dado1.getValor() + " e " + dado2.getValor());
                if (somaDados == 7) {
                    vencedor = jogador2;
                    System.out.println("Parabéns, " + jogador2.getNome() + ", você venceu!");
                    break;
                } else if (somaDados == jogador1.getPonto()) {
                    vencedor = jogador1;
                    System.out.println("Parabéns, " + jogador1.getNome() + ", você venceu!");
                    break;
                }
            }
        }
    }

    public Jogador getVencedor() {
        return vencedor;
    }
}
