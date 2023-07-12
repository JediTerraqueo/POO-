package com.mycompany.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, Palavra> palavras;
    private Map<String, Sinonimo> sinonimos;

    public Dicionario() {
        palavras = new HashMap<>();
        sinonimos = new HashMap<>();
    }

    public void adicionarPalavra(String palavra) {
        palavras.put(palavra, new Palavra(palavra));
    }

    public void adicionarGrafia(String palavra, String grafia) {
        Palavra p = palavras.get(palavra);
        if (p != null) {
            p.adicionarGrafia(grafia);
        }
    }

    public void adicionarSignificado(String palavra, String significado) {
        Palavra p = palavras.get(palavra);
        if (p != null) {
            p.adicionarSignificado(significado);
        }
    }

    public void adicionarVerbo(String palavra) {
        Palavra p = palavras.get(palavra);
        if (p != null) {
            p.setVerbo(true);
        }
    }

    public void adicionarSubstantivo(String palavra) {
        Palavra p = palavras.get(palavra);
        if (p != null) {
            p.setSubstantivo(true);
        }
    }

    public void adicionarSinonimo(String palavraPrincipal, String sinonimo, String descricao) {
        Sinonimo s = sinonimos.get(palavraPrincipal);
        if (s != null) {
            s.adicionarPalavraSinonima(sinonimo);
        } else {
            s = new Sinonimo(palavraPrincipal, descricao);
            s.adicionarPalavraSinonima(sinonimo);
            sinonimos.put(palavraPrincipal, s);
        }
    }

    public void listarPalavra(String palavra) {
        Palavra p = palavras.get(palavra);
        if (p != null) {
            System.out.println("Palavra: " + p.getPalavra());
            System.out.println("Grafias:");
            for (String grafia : p.getGrafias()) {
                System.out.println("- " + grafia);
            }
            System.out.println("Significados:");
            for (String significado : p.getSignificados()) {
                System.out.println("- " + significado);
            }
            System.out.println("Verbo: " + p.isVerbo());
            System.out.println("Substantivo: " + p.isSubstantivo());
        } else {
            System.out.println("Palavra não encontrada no dicionário.");
        }
    }

    public void listarSinonimos(String palavra) {
        Sinonimo s = sinonimos.get(palavra);
        if (s != null) {
            System.out.println("Palavra principal: " + s.getPalavraPrincipal());
            System.out.println("Sinônimos:");
            for (String sinonimo : s.getPalavrasSinonimas()) {
                System.out.println("- " + sinonimo);
            }
            System.out.println("Descrição: " + s.getDescricao());
        } else {
            System.out.println("Palavra não encontrada no dicionário.");
        }
    }
}
