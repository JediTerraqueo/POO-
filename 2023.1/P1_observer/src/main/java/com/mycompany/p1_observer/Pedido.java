package com.mycompany.p1_observer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pedido {
    private List<Observer> observers;
    private Map<String, List<String[]>> pedidos;

    public Pedido() {
        observers = new ArrayList<>();
        pedidos = new HashMap<>();
    }

    public void addPedido(String numeroPedido, String quantidade, String prato, String valorPrato) {
        String[] novoItemPedido = {numeroPedido, quantidade, prato, valorPrato};
        if (!pedidos.containsKey(numeroPedido)) {
            pedidos.put(numeroPedido, new ArrayList<>());
        }
        List<String[]> itensPedido = pedidos.get(numeroPedido);
        itensPedido.add(novoItemPedido);
        notifyObservers(numeroPedido, itensPedido);
    }

    public void processarPedidos(String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length >= 4) {
                    String numeroPedido = dados[0].trim();
                    String quantidade = dados[1].trim();
                    String prato = dados[2].trim();
                    String valorPrato = dados[3].trim();
                    addPedido(numeroPedido, quantidade, prato, valorPrato);
                } else {
                    System.out.println("Dados de pedido inválidos: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String numeroPedido, List<String[]> itensPedido) {
        for (Observer observer : observers) {
            observer.update(numeroPedido, itensPedido);
        }
    }
}
