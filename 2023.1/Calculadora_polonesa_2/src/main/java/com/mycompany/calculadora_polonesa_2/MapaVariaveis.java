package com.mycompany.calculadora_polonesa_2;

import java.util.ArrayList;
import java.util.List;

public class MapaVariaveis {
    private List<Variavel> variaveis;

    public MapaVariaveis() {
        variaveis = new ArrayList<>();
    }

    public void adicionarVariavel(String nome, double valor) {
        Variavel variavel = new Variavel(nome, valor);
        variaveis.add(variavel);
    }
    
public void limparVariaveis() {
    variaveis.clear();
}

    public Variavel getVariavel(String nome) {
        for (Variavel variavel : variaveis) {
            if (variavel.getNome().equals(nome)) {
                return variavel;
            }
        }
        return null;
    }
}
