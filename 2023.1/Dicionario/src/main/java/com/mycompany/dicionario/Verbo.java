package com.mycompany.dicionario;

public class Verbo extends Palavra {
    public Verbo(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "verbo";
    }
}
