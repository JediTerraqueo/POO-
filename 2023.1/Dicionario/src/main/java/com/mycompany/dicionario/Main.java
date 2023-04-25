package com.mycompany.dicionario;

public class Main {
    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        Substantivo substantivo1 = new Substantivo("cachorro");
        substantivo1.adicionarSinonimo(new Sinonimo("cão"));
        substantivo1.adicionarSinonimo(new Sinonimo("cãozinho"));

        Verbo verbo1 = new Verbo("correr");
        verbo1.adicionarSinonimo(new Sinonimo("correr muito"));
        verbo1.adicionarSinonimo(new Sinonimo("sprintar"));

        dicionario.adicionarPalavra(substantivo1);
        dicionario.adicionarPalavra(verbo1);

        Palavra palavra = dicionario.buscarPalavra("cachorro");
        if (palavra != null) {
            System.out.println(palavra.getNome() + " é um " + palavra.getTipo() + ".");
            System.out.println("Sinônimos:");
            for (Sinonimo sinonimo : palavra.getSinonimos()) {
                System.out.println("- " + sinonimo.getNome());
            }
        } else {
            System.out.println("Palavra não encontrada no dicionário.");
        }
    }
}
