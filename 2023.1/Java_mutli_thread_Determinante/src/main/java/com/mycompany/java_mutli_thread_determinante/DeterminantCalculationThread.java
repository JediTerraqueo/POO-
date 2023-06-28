package com.mycompany.java_mutli_thread_determinante;

public class DeterminantCalculationThread implements Runnable {
    private final double[][] matrix;
    private final int row;
    private final DeterminantCalculator calculator;
    private final int numThreads;
    private double result;

    public DeterminantCalculationThread(double[][] matrix, int row, DeterminantCalculator calculator, int numThreads) {
        this.matrix = matrix;
        this.row = row;
        this.calculator = calculator;
        this.numThreads = numThreads;
    }

    @Override
    public void run() {
        int size = matrix.length;
        double[][] subMatrix = new double[size - 1][size - 1];
        int subRowIndex = 0;

        for (int rowIndex = 1; rowIndex < size; rowIndex++) {
            int subColIndex = 0;

            for (int colIndex = 0; colIndex < size; colIndex++) {
                if (colIndex == row) {
                    continue;
                }

                subMatrix[subRowIndex][subColIndex] = matrix[rowIndex][colIndex];
                subColIndex++;
            }

            subRowIndex++;
        }

        double partialResult = matrix[0][row] * calculator.calculateDeterminant(subMatrix);
        result = (row % 2 == 0) ? partialResult : -partialResult;
    }

    public double getResult() {
        return result;
    }
}
