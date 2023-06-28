package com.mycompany.java_mutli_thread_determinante;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

public class DeterminantCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a ordem da matriz quadrada: ");
        int size = scanner.nextInt();

        double[][] matrix = new double[size][size];
        System.out.println("Digite os elementos da matriz:");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        int numThreads = Math.min(size, 8);

        DeterminantCalculator calculator = new DeterminantCalculatorImpl();

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        DeterminantCalculationThread[] threads = new DeterminantCalculationThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new DeterminantCalculationThread(matrix, i, calculator);
            executorService.execute(threads[i]);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double determinant = 0;

        for (int i = 0; i < numThreads; i++) {
            determinant += threads[i].getResult();
        }

        System.out.println("O determinante da matriz é: " + determinant);
    }
}
