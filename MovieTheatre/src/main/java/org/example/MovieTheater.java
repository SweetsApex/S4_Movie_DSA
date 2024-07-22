package org.example;

import java.util.Scanner;

public class MovieTheater {

    private char[][] seatingChart;
    private int rows;
    private int cols;

    public MovieTheater(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        seatingChart = new char[rows][cols];
        initializeSeatingChart();
    }

    private void initializeSeatingChart() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seatingChart[i][j] = '0'; // '0' represents an available seat
            }
        }
    }

    public void displaySeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean reserveSeat(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Invalid seat number.");
            return false;
        }
        if (seatingChart[row][col] == 'X') {
            System.out.println("Seat is already taken.");
            return false;
        }
        seatingChart[row][col] = 'X'; // 'X' represents a reserved seat
        System.out.println("Seat reserved successfully.");
        return true;
    }

    public static void main(String[] args) {
        MovieTheater theater = new MovieTheater(5, 5);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMovie Theater Menu:");
            System.out.println("1. Display seating chart");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    theater.displaySeatingChart();
                    break;
                case 2:
                    System.out.print("Enter row number: ");
                    int row = scanner.nextInt();
                    System.out.print("Enter column number: ");
                    int col = scanner.nextInt();
                    theater.reserveSeat(row, col);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
