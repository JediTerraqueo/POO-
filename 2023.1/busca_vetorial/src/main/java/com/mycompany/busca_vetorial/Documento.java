package com.mycompany.busca_vetorial;

public class Documento {
    private final String conteudo;

    public Documento(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public boolean contemPalavra(String palavra) {
        return conteudo.contains(palavra);
    }

    @Override
    public String toString() {
        return conteudo;
    }
}
