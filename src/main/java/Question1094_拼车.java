import java.util.Arrays;
import java.util.Comparator;

/**
 * 1094. 拼车
 * 提示
 * 中等
 * 324
 * 相关企业
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 */

public class Question1094_拼车 {
}

/**
 * @author Zhang Lei
 * @date 2023/12/2 14:32
 */
class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int length = trips.length;
        int[][] up = new int[length][2];
        int[][] down = new int[length][2];
        for (int i = 0; i < length; i++) {
            up[i][0] = trips[i][1];
            up[i][1] = trips[i][0];

            down[i][0] = trips[i][2];
            down[i][1] = trips[i][0];
        }

        Arrays.sort(up, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(down, Comparator.comparingInt(a -> a[0]));

        int indexUp = 0;
        int indexDown = 0;
        int count = 0;
        while (indexUp < length && indexDown < length) {
            if (up[indexUp][0] < down[indexDown][0]) {
                count += up[indexUp][1];
                if (count > capacity) {
                    return false;
                }
                indexUp++;
            } else {
                count -= down[indexDown][1];
                indexDown++;
            }
        }

        return true;
    }
}