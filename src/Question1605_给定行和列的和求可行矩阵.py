"""
1605. 给定行和列的和求可行矩阵
给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。

请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。

请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。



示例 1：

输入：rowSum = [3,8], colSum = [4,7]
输出：[[3,0],
      [1,7]]
解释：
第 0 行：3 + 0 = 3 == rowSum[0]
第 1 行：1 + 7 = 8 == rowSum[1]
第 0 列：3 + 1 = 4 == colSum[0]
第 1 列：0 + 7 = 7 == colSum[1]
行和列的和都满足题目要求，且所有矩阵元素都是非负的。
另一个可行的矩阵为：[[1,2],
                  [3,5]]
示例 2：

输入：rowSum = [5,7,10], colSum = [8,6,8]
输出：[[0,5,0],
      [6,1,0],
      [2,0,8]]
示例 3：

输入：rowSum = [14,9], colSum = [6,9,8]
输出：[[0,9,5],
      [6,0,3]]
示例 4：

输入：rowSum = [1,0], colSum = [1]
输出：[[1],
      [0]]
示例 5：

输入：rowSum = [0], colSum = [0]
输出：[[0]]


提示：

1 <= rowSum.length, colSum.length <= 500
0 <= rowSum[i], colSum[i] <= 108
sum(rowSum) == sum(colSum)
"""
from typing import List


class Solution:
    def restoreMatrix(self, rowSum: List[int], colSum: List[int]) -> List[List[int]]:
        row_length = len(rowSum)
        column_length = len(colSum)
        matrix = [[0] * column_length for _ in range(row_length)]
        for i in range(min(row_length, column_length) - 1):
            matrix[i][i] = min(rowSum[i], colSum[i])
            if rowSum[i] > colSum[i]:
                matrix[i][column_length - 1] = rowSum[i] - colSum[i]
            elif rowSum[i] < colSum[i]:
                matrix[row_length - 1][i] = colSum[i] - rowSum[i]

        if row_length > column_length:
            for i in range(column_length - 1, row_length - 1):
                matrix[i][column_length - 1] = rowSum[i]

            matrix[row_length - 1][column_length - 1] = colSum[column_length - 1] - sum(
                r[column_length - 1] for r in matrix)
        elif row_length < column_length:
            for i in range(row_length - 1, column_length - 1):
                matrix[row_length - 1][i] = colSum[i]

            matrix[row_length - 1][column_length - 1] = rowSum[row_length - 1] - sum(matrix[row_length - 1])
        else:
            matrix[row_length - 1][column_length - 1] = rowSum[row_length - 1] - sum(matrix[row_length - 1])

        row_index = 0
        column_index = 0
        while matrix[row_length - 1][column_length - 1] < 0:
            while row_index < row_length - 1 and matrix[row_index][column_length - 1] == 0:
                row_index += 1

            while column_index < column_length - 1 and matrix[row_length - 1][column_index] == 0:
                column_index += 1

            p = min(matrix[row_index][column_length - 1], matrix[row_length - 1][column_index])
            matrix[row_length - 1][column_length - 1] += p
            matrix[row_index][column_index] += p
            matrix[row_index][column_length - 1] -= p
            matrix[row_length - 1][column_index] -= p

        return matrix


if __name__ == '__main__':
    s = Solution()
    # print(s.restoreMatrix([3, 8], [4, 7]))
    # print(s.restoreMatrix([5, 7, 10], [8, 6, 8]))
    # print(s.restoreMatrix([14, 9], [6, 9, 8]))
    # print(s.restoreMatrix([1, 0], [1]))
    print(s.restoreMatrix([22, 5, 28, 15, 5, 21, 44, 8, 68, 47], [42, 14, 18, 29, 27, 40, 31, 48, 14]))
