package com.mycompany.dicionario;

import java.util.ArrayList;
import java.util.List;

public class Palavra {
    private String palavra;
    private List<String> grafias;
    private List<String> significados;
    private boolean verbo;
    private boolean substantivo;

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.grafias = new ArrayList<>();
        this.significados = new ArrayList<>();
        this.verbo = false;
        this.substantivo = false;
    }

    public String getPalavra() {
        return palavra;
    }

    public List<String> getGrafias() {
        return grafias;
    }

    public List<String> getSignificados() {
        return significados;
    }

    public boolean isVerbo() {
        return verbo;
    }

    public boolean isSubstantivo() {
        return substantivo;
    }

    public void adicionarGrafia(String grafia) {
        grafias.add(grafia);
    }

    public void adicionarSignificado(String significado) {
        significados.add(significado);
    }

    public void setVerbo(boolean verbo) {
        this.verbo = verbo;
    }

    public void setSubstantivo(boolean substantivo) {
        this.substantivo = substantivo;
    }
}
