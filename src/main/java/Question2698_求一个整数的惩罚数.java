/**
 * 2698. 求一个整数的惩罚数
 * 提示
 * 中等
 * 50
 * 相关企业
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * <p>
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * <p>
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：182
 * 解释：总共有 3 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * 因此，10 的惩罚数为 1 + 81 + 100 = 182
 * 示例 2：
 * <p>
 * 输入：n = 37
 * 输出：1478
 * 解释：总共有 4 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * - 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
 * 因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */

public class Question2698_求一个整数的惩罚数 {
}

class Solution2698 {
    public int punishmentNumber(int n) {
        int punishmentNumber = 0;
        for (int i = 1; i <= n; i++) {
            int ii = i * i;
            if (backtrack(Integer.toString(ii), i, 0, 0)) {
                punishmentNumber += ii;
            }
        }

        return punishmentNumber;
    }

    public boolean backtrack(String num, int numI, int index, int sum) {
        if (index == num.length() && sum == numI) {
            return true;
        }

        if (sum > numI) {
            return false;
        }

        boolean find = false;
        int s = 0;
        for (int i = index; i < num.length(); i++) {
            s = s * 10 + num.charAt(i) - '0';
            find = find || backtrack(num, numI, i + 1, sum + s);
        }

        return find;
    }
}