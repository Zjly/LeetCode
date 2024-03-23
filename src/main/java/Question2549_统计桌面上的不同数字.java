import java.util.HashSet;
import java.util.Set;

/**
 * 2549. 统计桌面上的不同数字
 * 第 330 场周赛
 * Q1
 * 1266
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n ，开始时，它放在桌面上。在 109 天内，每天都要执行下述步骤：
 * <p>
 * 对于出现在桌面上的每个数字 x ，找出符合 1 <= i <= n 且满足 x % i == 1 的所有数字 i 。
 * 然后，将这些数字放在桌面上。
 * 返回在 109 天之后，出现在桌面上的 不同 整数的数目。
 * <p>
 * 注意：
 * <p>
 * 一旦数字放在桌面上，则会一直保留直到结束。
 * % 表示取余运算。例如，14 % 3 等于 2 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：4
 * 解释：最开始，5 在桌面上。
 * 第二天，2 和 4 也出现在桌面上，因为 5 % 2 == 1 且 5 % 4 == 1 。
 * 再过一天 3 也出现在桌面上，因为 4 % 3 == 1 。
 * 在十亿天结束时，桌面上的不同数字有 2 、3 、4 、5 。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：
 * 因为 3 % 2 == 1 ，2 也出现在桌面上。
 * 在十亿天结束时，桌面上的不同数字只有两个：2 和 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 */

public class Question2549_统计桌面上的不同数字 {
}

/**
 * @author Zhang Lei
 * @date 2024/3/23 15:23
 */
class Solution2549 {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (true) {
            Set<Integer> newSet = new HashSet<>();

            for (Integer num : set) {
                for (int i = 1; i < num; i++) {
                    if (num % i == 1) {
                        newSet.add(i);
                    }
                }
            }

            int size1 = set.size();
            set.addAll(newSet);
            int size2 = set.size();

            if (size1 == size2) {
                return set.size();
            }
        }
    }
}

/**
 * @author Zhang Lei
 * @date 2024/3/23 15:30
 */
class Solution2549_2 {
    public int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }
}