/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arman
 */
import java.util.Scanner;
import java.util.List;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Serie de Fibonacci (recursivo)");
            System.out.println("2. Problema Subset Sum (suma de subconjuntos)");
            System.out.println("3. Resolver Sudoku (backtracking)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> ejecutarFibonacci();
                case 2 -> ejecutarSubsetSum();
                case 3 -> ejecutarSudoku();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void ejecutarFibonacci() {
        System.out.print("Introduce n: ");
        int n = sc.nextInt();
        long resultado = FibonacciRecursivo.fibMemo(n);
        System.out.println("Fibonacci(" + n + ") = " + resultado);
    }

    private static void ejecutarSubsetSum() {
        System.out.print("Introduce el tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Introduce los elementos:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Introduce el valor objetivo: ");
        int target = sc.nextInt();

        boolean existe = SubsetSumRecursivo.subsetSumExists(nums, target);
        System.out.println("¿Existe subconjunto que sume " + target + "? " + existe);

        if (existe) {
            List<Integer> subset = SubsetSumRecursivo.findOneSubset(nums, target);
            System.out.println("Un subconjunto solución: " + subset);
        }
    }

    private static void ejecutarSudoku() {
        int[][] board = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };

        System.out.println("Tablero inicial:");
        SudokuSolver.printBoard(board);

        if (SudokuSolver.solveSudoku(board)) {
            System.out.println("\nSolución:");
            SudokuSolver.printBoard(board);
        } else {
            System.out.println("No tiene solución.");
        }
    }
}