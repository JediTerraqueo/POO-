package com.mycompany.calculadora_polonesa_2;

import java.util.ArrayList;
import java.util.List;

public class Pilha<T> {
    private List<T> elementos;

    public Pilha() {
        this.elementos = new ArrayList<>();
    }

    public void push(T elemento) {
        elementos.add(elemento);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia.");
        }
        return elementos.remove(elementos.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia.");
        }
        return elementos.get(elementos.size() - 1);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public void clear() {
        elementos.clear();
    }
}
