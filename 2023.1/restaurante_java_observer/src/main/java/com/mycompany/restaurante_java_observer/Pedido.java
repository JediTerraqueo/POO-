package com.mycompany.restaurante_java_observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {
    private int numero;
    private ArrayList<Item> itens;

    public Pedido(int numero) {
        this.numero = numero;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Prato prato, int quantidade) {
        Item item = new Item(prato, quantidade);
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public void modificarQuantidade(Item item, int novaQuantidade) {
        item.setQuantidade(novaQuantidade);
    }

    public void salvarPedido(String arquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(this.numero + ";");

            for (Item item : itens) {
                Prato prato = item.getPrato();
                int quantidade = item.getQuantidade();

                bw.write(quantidade + ";" + prato.getNome() + ";");
            }

            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o pedido: " + e.getMessage());
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Item item : itens) {
            Prato prato = item.getPrato();
            int quantidade = item.getQuantidade();
            double preco = prato.getPreco();

            valorTotal += preco * quantidade;
        }

        return valorTotal;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }



}

