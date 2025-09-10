/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arman
 */
import java.util.*;

public class SubsetSumRecursivo {

    public static boolean subsetSumExists(int[] nums, int target) {
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(nums, 0, target, memo);
    }

    private static boolean dfs(int[] nums, int idx, int remaining, Map<String, Boolean> memo) {
        String key = idx + "|" + remaining;
        if (memo.containsKey(key)) return memo.get(key);

        if (remaining == 0) return true;       // caso base
        if (idx == nums.length) return false;  // caso base

        // Incluir
        if (dfs(nums, idx + 1, remaining - nums[idx], memo)) {
            memo.put(key, true);
            return true;
        }

        // Excluir
        boolean res = dfs(nums, idx + 1, remaining, memo);
        memo.put(key, res);
        return res;
    }

    public static List<Integer> findOneSubset(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        if (build(nums, 0, target, path)) return path;
        return Collections.emptyList();
    }

    private static boolean build(int[] nums, int idx, int remaining, List<Integer> path) {
        if (remaining == 0) return true;
        if (idx == nums.length) return false;

        // Incluir
        path.add(nums[idx]);
        if (build(nums, idx + 1, remaining - nums[idx], path)) return true;
        path.remove(path.size() - 1);

        // Excluir
        return build(nums, idx + 1, remaining, path);
    }
}

