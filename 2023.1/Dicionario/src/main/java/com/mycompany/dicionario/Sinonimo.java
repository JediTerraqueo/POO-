package com.mycompany.dicionario;

import java.util.ArrayList;
import java.util.List;

public class Sinonimo {
    private String palavraPrincipal;
    private List<String> palavrasSinonimas;
    private String descricao;

    public Sinonimo(String palavraPrincipal, String descricao) {
        this.palavraPrincipal = palavraPrincipal;
        this.palavrasSinonimas = new ArrayList<>();
        this.descricao = descricao;
    }

    public String getPalavraPrincipal() {
        return palavraPrincipal;
    }

    public List<String> getPalavrasSinonimas() {
        return palavrasSinonimas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void adicionarPalavraSinonima(String palavraSinonima) {
        palavrasSinonimas.add(palavraSinonima);
    }
}
