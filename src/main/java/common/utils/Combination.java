package common.utils;


import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static List<List<Integer>> combine(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combineHelper(result, current, nums, 0);
        return result;
    }

    private static void combineHelper(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        if (current.size() == nums[1]) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums[0]; i++) {
            current.add(i);
            combineHelper(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
