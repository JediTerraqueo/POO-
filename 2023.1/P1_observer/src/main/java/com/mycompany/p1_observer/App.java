package com.mycompany.p1_observer;

import java.util.List;

class App implements Observer {
    @Override
    public void update(String numeroPedido, List<String[]> itensPedido) {
        System.out.println("Pedido número: " + numeroPedido);
        for (String[] item : itensPedido) {
            System.out.println("Prato: " + item[2] + ", Quantidade: " + item[1]);
        }
        System.out.println("Valor total do pedido: " + calcularValorTotal(itensPedido));
        System.out.println();
    }

    private double calcularValorTotal(List<String[]> itensPedido) {
        double valorTotal = 0;
        for (String[] item : itensPedido) {
            double quantidade = Double.parseDouble(item[1]);
            double valorPrato = Double.parseDouble(item[3]);
            valorTotal += quantidade * valorPrato;
        }
        return valorTotal;
    }
}
