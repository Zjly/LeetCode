package CY26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangLei
 * @version 2026/04/16 23:44
 */
public class Question3488_距离最小相等元素查询 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> indexList = numIndexMap.getOrDefault(num, new ArrayList<>());
            indexList.add(i);
            numIndexMap.put(num, indexList);
        }

        List<Integer> res = new ArrayList<>();
        for (int query : queries) {
            List<Integer> indexList = numIndexMap.get(nums[query]);

            // 如果该元素只有一个位置，返回-1
            if (indexList.size() == 1) {
                res.add(-1);
                continue;
            }

            // 二分查找 query 在 indexList 中的位置
            int pos = binarySearch(indexList, query);
            int n = nums.length;
            int minDis = Integer.MAX_VALUE;

            // 检查左邻居
            if (pos > 0) {
                int leftIndex = indexList.get(pos - 1);
                minDis = Math.min(minDis, Math.min(Math.abs(query - leftIndex), n - Math.abs(query - leftIndex)));
            }
            // 检查右邻居
            if (pos < indexList.size() - 1) {
                int rightIndex = indexList.get(pos + 1);
                minDis = Math.min(minDis, Math.min(Math.abs(query - rightIndex), n - Math.abs(query - rightIndex)));
            }
            // 环形数组：首尾元素可能最近（当 pos 在端点时）
            if (pos == 0) {
                int tailIndex = indexList.get(indexList.size() - 1);
                minDis = Math.min(minDis, Math.min(Math.abs(query - tailIndex), n - Math.abs(query - tailIndex)));
            }
            if (pos == indexList.size() - 1) {
                int headIndex = indexList.get(0);
                minDis = Math.min(minDis, Math.min(Math.abs(query - headIndex), n - Math.abs(query - headIndex)));
            }

            res.add(minDis);
        }

        return res;
    }

    /**
     * 二分查找 target 在有序列表中的位置
     */
    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // 不应该发生，因为 target 一定在列表中
    }
}
