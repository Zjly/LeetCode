import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1424. 对角线遍历 II
 * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,4,2,7,5,3,8,6,9]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * 输出：[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 * 示例 3：
 * <p>
 * 输入：nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * 输出：[1,4,2,5,3,8,6,9,7,10,11]
 * 示例 4：
 * <p>
 * 输入：nums = [[1,2,3,4,5,6]]
 * 输出：[1,2,3,4,5,6]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i].length <= 10^5
 * 1 <= nums[i][j] <= 10^9
 * nums 中最多有 10^5 个数字。
 */

public class Question1424_对角线遍历II {
}

/**
 * @author Zhang Lei
 * @date 2023/8/10 23:22
 */
class Solution1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                list.add(new int[]{i + j, j, nums.get(i).get(j)});
            }
        }

        list.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i)[2];
        }

        return result;
    }
}