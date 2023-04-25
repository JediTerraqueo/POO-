package com.mycompany.dicionario;

import java.util.ArrayList;
import java.util.List;

public abstract class Palavra {
    protected String nome;
    protected List<Sinonimo> sinonimos;

    public Palavra(String nome) {
        this.nome = nome;
        this.sinonimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Sinonimo> getSinonimos() {
        return sinonimos;
    }

    public void adicionarSinonimo(Sinonimo sinonimo) {
        sinonimos.add(sinonimo);
    }

    public abstract String getTipo();
}
