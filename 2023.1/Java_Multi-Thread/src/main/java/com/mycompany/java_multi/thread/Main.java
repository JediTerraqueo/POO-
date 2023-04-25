package com.mycompany.java_multi.thread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Double> numeros = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            numeros.add((double) i);
        }

        int numThreads = 10;
        double somaTotal = 0;

        List<CalculadoraMediaThread> threads = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            int inicio = (i * numeros.size()) / numThreads;
            int fim = ((i + 1) * numeros.size()) / numThreads;
            threads.add(new CalculadoraMediaThread(numeros.subList(inicio, fim)));
        }

        for (CalculadoraMediaThread thread : threads) {
            thread.start();
        }

        for (CalculadoraMediaThread thread : threads) {
            thread.join();
            somaTotal += thread.getSoma();
        }

        double media = somaTotal / numeros.size();
        System.out.println("A média dos números é: " + media);
    }
}

class CalculadoraMediaThread extends Thread {
    private List<Double> numeros;
    private double soma;

    public CalculadoraMediaThread(List<Double> numeros) {
        this.numeros = numeros;
    }

    public void run() {
        for (Double numero : numeros) {
            soma += numero;
        }
    }

    public double getSoma() {
        return soma;
    }
}
