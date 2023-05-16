package com.mycompany.busca_vetorial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Buscador<T> {
    private final List<T> objetos;

    public Buscador() {
        objetos = new ArrayList<>();
    }

    public void adicionarObjeto(T objeto) {
        objetos.add(objeto);
    }

    public void removerObjeto(T objeto) {
        objetos.remove(objeto);
    }

    public List<T> buscar(Predicate<T> predicado) {
        List<T> resultados = new ArrayList<>();
        for (T objeto : objetos) {
            if (predicado.test(objeto)) {
                resultados.add(objeto);
            }
        }
        return resultados;
    }

    public List<T> getObjetos() {
        return objetos;
    }
}
