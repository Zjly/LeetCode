import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1954. 收集足够苹果的最小花园周长
 * 提示
 * 1759
 * 58
 * 第 252 场周赛
 * Q3
 * 相关企业
 * 给你一个用无限二维网格表示的花园，每一个 整数坐标处都有一棵苹果树。整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果。
 * <p>
 * 你将会买下正中心坐标是 (0, 0) 的一块 正方形土地 ，且每条边都与两条坐标轴之一平行。
 * <p>
 * 给你一个整数 neededApples ，请你返回土地的 最小周长 ，使得 至少 有 neededApples 个苹果在土地 里面或者边缘上。
 * <p>
 * |x| 的值定义为：
 * <p>
 * 如果 x >= 0 ，那么值为 x
 * 如果 x < 0 ，那么值为 -x
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：neededApples = 1
 * 输出：8
 * 解释：边长长度为 1 的正方形不包含任何苹果。
 * 但是边长为 2 的正方形包含 12 个苹果（如上图所示）。
 * 周长为 2 * 4 = 8 。
 * 示例 2：
 * <p>
 * 输入：neededApples = 13
 * 输出：16
 * 示例 3：
 * <p>
 * 输入：neededApples = 1000000000
 * 输出：5040
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= neededApples <= 1015
 */

public class Question1954_收集足够苹果的最小花园周长 {
    Solution1954 solution1954 = new Solution1954();

    @Test
    public void test() {
        long neededApples = 13;
        Assertions.assertEquals(16, solution1954.minimumPerimeter(neededApples));
    }

    @Test
    public void test2() {
        long neededApples = 1000000000;
        Assertions.assertEquals(5040, solution1954.minimumPerimeter(neededApples));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/12/24 21:11
 */
class Solution1954 {
    public long minimumPerimeter(long neededApples) {
        long length = 1;
        long apples = 0;

        while (apples < neededApples) {
            length++;
            long sum = (length - 1) * 4 + (3 * length - 3) * (length - 2) / 2 * 8 + (2 * length - 2) * 4;
            apples += sum;
        }

        return (length - 1) * 8;
    }
}
