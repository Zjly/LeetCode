/**
 * 2661. 找出叠涂元素
 * 提示
 * 中等
 * 56
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 * <p>
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 * <p>
 * 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * image explanation for example 1
 * 输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
 * 输出：2
 * 解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
 * 示例 2：
 * <p>
 * image explanation for example 2
 * 输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
 * 输出：3
 * 解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n = mat[i].length
 * arr.length == m * n
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= arr[i], mat[r][c] <= m * n
 * arr 中的所有整数 互不相同
 * mat 中的所有整数 互不相同
 */

public class Question2661_找出叠涂元素 {
}

/**
 * @author Zhang Lei
 * @date 2023/12/1 21:11
 */
class Solution2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] index = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                index[mat[i][j]][0] = i;
                index[mat[i][j]][1] = j;
            }
        }

        int[] mCount = new int[m];
        int[] nCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int row = index[arr[i]][0];
            int column = index[arr[i]][1];

            mCount[row]++;
            if (mCount[row] == n) {
                return i;
            }

            nCount[column]++;
            if (nCount[column] == m) {
                return i;
            }
        }

        return -1;
    }
}