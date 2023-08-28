import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 823. 带因子的二叉树
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 * <p>
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * <p>
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: arr = [2, 4]
 * 输出: 3
 * 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 * <p>
 * 输入: arr = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 109
 * arr 中的所有值 互不相同
 */

public class Question823_带因子的二叉树 {
    Solution823 solution823 = new Solution823();

    @Test
    public void test() {
        int[] arr = {2, 4, 5, 10};
        Assertions.assertEquals(7, solution823.numFactoredBinaryTrees(arr));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/8/29 0:12
 */
class Solution823 {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = 1000000007;
        long count = 0;

        Map<Integer, Long> map = new HashMap<>();
        Arrays.sort(arr);
        for (int i : arr) {
            map.put(i, 1L);
        }

        for (int i = 0; i < arr.length; i++) {
            int numI = arr[i];
            for (int j = 0; arr[j] * arr[j] <= numI; j++) {
                int numJ = arr[j];
                int numIJ = numI / numJ;
                if (numI % numJ == 0 && map.containsKey(numIJ)) {
                    long countI = (map.get(numJ) * map.get(numIJ)) % MOD;
                    countI = numJ == numIJ ? countI : (countI * 2) % MOD;
                    countI = (countI + map.get(numI)) % MOD;
                    map.put(numI, countI);
                }
            }

            count = (count + map.get(numI)) % MOD;
        }

        return (int)count;
    }
}