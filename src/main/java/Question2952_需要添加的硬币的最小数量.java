import java.util.Arrays;

/**
 * 2952. 需要添加的硬币的最小数量
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
 * <p>
 * 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
 * <p>
 * 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
 * <p>
 * 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1,4,10], target = 19
 * 输出：2
 * 解释：需要添加面值为 2 和 8 的硬币各一枚，得到硬币数组 [1,2,4,8,10] 。
 * 可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 2 。
 * 示例 2：
 * <p>
 * 输入：coins = [1,4,10,5,7,19], target = 19
 * 输出：1
 * 解释：只需要添加一枚面值为 2 的硬币，得到硬币数组 [1,2,4,5,7,10,19] 。
 * 可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 1 。
 * 示例 3：
 * <p>
 * 输入：coins = [1,1,1], target = 20
 * 输出：3
 * 解释：
 * 需要添加面值为 4 、8 和 16 的硬币各一枚，得到硬币数组 [1,1,1,4,8,16] 。
 * 可以证明从 1 到 20 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 105
 * 1 <= coins.length <= 105
 * 1 <= coins[i] <= target
 */

public class Question2952_需要添加的硬币的最小数量 {
}

/**
 * @author Zhang Lei
 * @date 2024/3/30 17:27
 */
class Solution2952 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int count = 0;
        int index = 1;
        int coinsIndex = 0;
        while (index <= target) {
            if (coinsIndex < coins.length && coins[coinsIndex] <= index) {
                index += coins[coinsIndex];
                coinsIndex++;
            } else {
                index *= 2;
                count++;
            }
        }

        return count;
    }
}