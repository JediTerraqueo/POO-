package com.mycompany.dicionario;

public class Substantivo extends Palavra {
    public Substantivo(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "substantivo";
    }
}
