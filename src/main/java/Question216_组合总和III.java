import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 * 算术评级: 4
 * 中等
 * 相关标签
 * 相关企业
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 */

public class Question216_组合总和III {
}

/**
 * @author Zhang Lei
 * @date 2024/4/21 23:00
 */
class Solution216 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new ArrayList<>(), k, n, 0, 1);
        return result;
    }

    public void dfs(List<Integer> list, int k, int n, int sum, int index) {
        if (sum == n && list.size() == k) {
            List<Integer> re = new ArrayList<>(list);
            result.add(re);
            return;
        }

        if (index > 9 || sum > n || list.size() > k) {
            return;
        }

        list.add(index);
        sum += index;
        dfs(list, k, n, sum, index + 1);

        list.remove(list.size() - 1);
        sum -= index;
        dfs(list, k, n, sum, index + 1);
    }
}