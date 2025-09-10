/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arman
 */
public class SudokuSolver {

    private static final int N = 9;

    public static boolean solveSudoku(int[][] board) {
        return backtrack(board, 0, 0);
    }

    private static boolean backtrack(int[][] board, int row, int col) {
        if (row == N) return true; // resuelto

        int nextRow = (col == N - 1) ? row + 1 : row;
        int nextCol = (col + 1) % N;

        if (board[row][col] != 0) {
            return backtrack(board, nextRow, nextCol);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (backtrack(board, nextRow, nextCol)) return true;
                board[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int r, int c, int val) {
        for (int i = 0; i < N; i++) {
            if (board[r][i] == val) return false;
            if (board[i][c] == val) return false;
        }
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[sr + i][sc + j] == val) return false;
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int r = 0; r < N; r++) {
            if (r % 3 == 0 && r != 0) {
                System.out.println("------+-------+------");
            }
            for (int c = 0; c < N; c++) {
                if (c % 3 == 0 && c != 0) System.out.print("| ");
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}

