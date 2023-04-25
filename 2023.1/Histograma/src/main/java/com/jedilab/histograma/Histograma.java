package com.jedilab.histograma;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Histograma {

    public static void createFileWithRandomNumbers(int n) throws IOException {
        File file = new File("random_numbers.txt");
        try (FileWriter writer = new FileWriter(file)) {
            Random random = new Random();
            
            for (int i = 0; i < n; i++) {
                int randomNumber = random.nextInt(100);
                writer.write(randomNumber + "\n");
            }
        }
    }

    public static double[] calculateHistogram(int[] numbers) {
        double[] histogram = new double[100];

        for (int number : numbers) {
            histogram[number]++;
        }

        for (int i = 0; i < histogram.length; i++) {
            histogram[i] = histogram[i] / numbers.length * 100;
        }

        return histogram;
    }

public static void printHistogram(int[] numbers) {
    double[] histogram = calculateHistogram(numbers);

    for (int i = 0; i < histogram.length; i++) {
        System.out.printf("%2d | ", i);

        for (int j = 0; j < Math.round(histogram[i]); j++) {
            System.out.print("#");
        }

        System.out.printf(" %.2f%%\n", histogram[i]);
    }
}
    public static void main(String[] args) throws IOException {
        int n = 1000;
        createFileWithRandomNumbers(n);

        // Read the file and store the numbers in an array
        int[] numbers = new int[n];
        java.util.Scanner scanner = new java.util.Scanner(new File("random_numbers.txt"));

        int i = 0;
        while (scanner.hasNextInt()) {
            numbers[i++] = scanner.nextInt();
        }

        printHistogram(numbers);
    }
}
