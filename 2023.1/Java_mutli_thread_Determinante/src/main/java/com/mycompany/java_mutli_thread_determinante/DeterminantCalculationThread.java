package com.mycompany.java_mutli_thread_determinante;

public class DeterminantCalculationThread implements Runnable {
    private final double[][] matrix;
    private final int row;
    private final DeterminantCalculator calculator;
    private double result;

    public DeterminantCalculationThread(double[][] matrix, int row, DeterminantCalculator calculator) {
        this.matrix = matrix;
        this.row = row;
        this.calculator = calculator;
    }

    @Override
    public void run() {
        double[][] subMatrix = createSubMatrix(matrix, row, 0);
        result = matrix[row][0] * calculator.calculateDeterminant(subMatrix);
    }

    private double[][] createSubMatrix(double[][] matrix, int rowToRemove, int colToRemove) {
        int size = matrix.length;
        double[][] subMatrix = new double[size - 1][size - 1];

        int rowIndex = 0;
        for (int i = 0; i < size; i++) {
            if (i == rowToRemove) {
                continue;
            }

            int colIndex = 0;
            for (int j = 0; j < size; j++) {
                if (j == colToRemove) {
                    continue;
                }

                subMatrix[rowIndex][colIndex] = matrix[i][j];
                colIndex++;
            }

            rowIndex++;
        }

        return subMatrix;
    }

    public double getResult() {
        return result;
    }
}
