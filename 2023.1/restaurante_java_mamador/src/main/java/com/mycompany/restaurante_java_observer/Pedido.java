package com.mycompany.restaurante_java_observer;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private List<Item> itens;

    public Pedido(int numero) {
        this.numero = numero;
        itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }
}
