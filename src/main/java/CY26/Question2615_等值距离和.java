package CY26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangLei
 * @version 2026/04/23 23:43
 */
public class Question2615_等值距离和 {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list;
            if (numsMap.containsKey(nums[i])) {
                list = numsMap.get(nums[i]);
            } else {
                list = new ArrayList<>();
            }

            list.add(i);
            numsMap.put(nums[i], list);
        }

        long[] res = new long[nums.length];
        for (List<Integer> list : numsMap.values()) {
            if (list.size() == 1) {
                res[list.get(0)] = 0;
                continue;
            }

            long p = 0;
            int firstIndex = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                p += list.get(i) - firstIndex;
            }
            res[list.get(0)] = p;

            for (int i = 1; i < list.size(); i++) {
                int diff = list.get(i) - list.get(i - 1);
                p = p + (long)diff * (i - 1) - (long)diff * (list.size() - 1 - i);
                res[list.get(i)] = p;
            }
        }

        return res;
    }
}
