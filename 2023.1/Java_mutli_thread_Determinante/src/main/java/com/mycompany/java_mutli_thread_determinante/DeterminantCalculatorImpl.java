package com.mycompany.java_mutli_thread_determinante;

public class DeterminantCalculatorImpl implements DeterminantCalculator {
    @Override
    public double calculateDeterminant(double[][] matrix) {
        int size = matrix.length;
        if (size != matrix[0].length) {
            throw new IllegalArgumentException("A matriz deve ser quadrada.");
        }

        if (size == 1) {
            return matrix[0][0];
        }

        double determinant = 0;

        for (int col = 0; col < size; col++) {
            determinant += matrix[0][col] * cofactor(matrix, 0, col);
        }

        return determinant;
    }

    private double cofactor(double[][] matrix, int row, int col) {
        int sign = ((row + col) % 2 == 0) ? 1 : -1;
        double[][] subMatrix = createSubMatrix(matrix, row, col);
        return sign * calculateDeterminant(subMatrix);
    }

    private double[][] createSubMatrix(double[][] matrix, int rowToRemove, int colToRemove) {
        int size = matrix.length;
        double[][] subMatrix = new double[size - 1][size - 1];

        int rowIndex = 0;
        for (int row = 0; row < size; row++) {
            if (row == rowToRemove) {
                continue;
            }

            int colIndex = 0;
            for (int col = 0; col < size; col++) {
                if (col == colToRemove) {
                    continue;
                }

                subMatrix[rowIndex][colIndex] = matrix[row][col];
                colIndex++;
            }

            rowIndex++;
        }

        return subMatrix;
    }
}
