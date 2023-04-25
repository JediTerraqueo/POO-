package com.jedilab.jogo_dos_dados;

import java.util.Random;

public class JogoDeDados {
    public static void main(String[] args) {
        Random rand = new Random();
        int ponto = 0;
        boolean vitoria = false;
        
        // Lançamento inicial
        int lancamento = rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
        System.out.println("Lançamento inicial: " + lancamento);
        
        switch (lancamento) {
            case 7, 11 -> {
                vitoria = true;
                System.out.println("Você venceu!");
            }
            case 2, 3, 12 -> {
                vitoria = false;
                System.out.println("Você perdeu!");
            }
            default -> {
                ponto = lancamento;
                System.out.println("Seu ponto é: " + ponto);
            }
        }
        
        // Lançamentos subsequentes
        while (!vitoria && ponto != 7) {
            lancamento = rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
            System.out.println("Próximo lançamento: " + lancamento);
            
            if (lancamento == ponto) {
                vitoria = true;
                System.out.println("Você venceu!");
            } else if (lancamento == 7) {
                vitoria = false;
                System.out.println("Você perdeu!");
            }
        }
    }
}
