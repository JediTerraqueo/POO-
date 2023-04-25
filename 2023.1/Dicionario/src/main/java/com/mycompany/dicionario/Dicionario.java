package com.mycompany.dicionario;

import java.util.ArrayList;
import java.util.List;

public class Dicionario {
    private List<Palavra> palavras;

    public Dicionario() {
        this.palavras = new ArrayList<>();
    }

    public void adicionarPalavra(Palavra palavra) {
        palavras.add(palavra);
    }

    public Palavra buscarPalavra(String nome) {
        for (Palavra palavra : palavras) {
            if (palavra.getNome().equalsIgnoreCase(nome)) {
                return palavra;
            }
        }
        return null;
    }
}
