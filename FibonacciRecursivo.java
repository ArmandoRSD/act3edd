/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arman
 */
public class FibonacciRecursivo {

    // Versión recursiva con memoización (para evitar muchas llamadas)
    public static long fibMemo(int n) {
        if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
        long[] memo = new long[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;
        return fibMemoHelper(n, memo);
    }

    private static long fibMemoHelper(int n, long[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != -1) return memo[n];
        memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
        return memo[n];
    }
}
