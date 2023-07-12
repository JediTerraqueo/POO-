package com.mycompany.dicionario;

public class Main {
    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        // Adicionar palavras
        dicionario.adicionarPalavra("casa");
        dicionario.adicionarPalavra("lar");

        // Adicionar grafias
        dicionario.adicionarGrafia("casa", "kasa");
        dicionario.adicionarGrafia("lar", "laar");

        // Adicionar significados
        dicionario.adicionarSignificado("casa", "residência");
        dicionario.adicionarSignificado("lar", "moradia");

        // Adicionar verbo e substantivo
        dicionario.adicionarVerbo("casa");
        dicionario.adicionarSubstantivo("lar");

        // Adicionar sinonimos
        dicionario.adicionarSinonimo("casa", "habitação", "lugar onde se mora");
        dicionario.adicionarSinonimo("lar", "morada", "local de habitação");

        // Listar palavras
        dicionario.listarPalavra("casa");
        System.out.println("-------------");
        dicionario.listarPalavra("lar");
        System.out.println("-------------");
        dicionario.listarPalavra("teste");

        // Listar sinonimos
        System.out.println("-------------");
        dicionario.listarSinonimos("casa");
        System.out.println("-------------");
        dicionario.listarSinonimos("lar");
        System.out.println("-------------");
        dicionario.listarSinonimos("teste");
    }
}
