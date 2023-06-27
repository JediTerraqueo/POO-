package com.mycompany.java_mutli_thread_determinante;


interface DeterminantCalculator {
    double calculateDeterminant(double[][] matrix);
}

class DeterminantCalculatorImpl implements DeterminantCalculator {
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

        for (int i = 0; i < size; i++) {
            determinant += matrix[0][i] * cofactor(matrix, 0, i);
        }

        return determinant;
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

    private double cofactor(double[][] matrix, int row, int col) {
        int sign = ((row + col) % 2 == 0) ? 1 : -1;
        double[][] subMatrix = createSubMatrix(matrix, row, col);
        return sign * calculateDeterminant(subMatrix);
    }
}

class DeterminantCalculationThread extends Thread {
    private final double[][] matrix;
    private final int startRow;
    private final int endRow;
    private final DeterminantCalculator calculator;
    private double result;

    public DeterminantCalculationThread(double[][] matrix, int startRow, int endRow, DeterminantCalculator calculator) {
        this.matrix = matrix;
        this.startRow = startRow;
        this.endRow = endRow;
        this.calculator = calculator;
    }

    @Override
    public void run() {
        for (int i = startRow; i <= endRow; i++) {
            double[][] subMatrix = createSubMatrix(matrix, i);
            double subDeterminant = calculator.calculateDeterminant(subMatrix);
            result += matrix[i][0] * subDeterminant;
        }
    }

    private double[][] createSubMatrix(double[][] matrix, int rowToRemove) {
        int size = matrix.length;
        double[][] subMatrix = new double[size - 1][size - 1];

        int rowIndex = 0;
        for (int i = 1; i < size; i++) {
            int colIndex = 0;
            for (int j = 0; j < size; j++) {
                if (j != rowToRemove) {
                    subMatrix[rowIndex][colIndex] = matrix[i][j];
                    colIndex++;
                }
            }
            rowIndex++;
        }

        return subMatrix;
    }

    public double getResult() {
        return result;
    }
}

