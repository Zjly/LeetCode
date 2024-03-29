"""
1326. 灌溉花园的最少水龙头数目
在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。

花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。

给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。

请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。



示例 1：



输入：n = 5, ranges = [3,4,1,1,0,0]
输出：1
解释：
点 0 处的水龙头可以灌溉区间 [-3,3]
点 1 处的水龙头可以灌溉区间 [-3,5]
点 2 处的水龙头可以灌溉区间 [1,3]
点 3 处的水龙头可以灌溉区间 [2,4]
点 4 处的水龙头可以灌溉区间 [4,4]
点 5 处的水龙头可以灌溉区间 [5,5]
只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
示例 2：

输入：n = 3, ranges = [0,0,0,0]
输出：-1
解释：即使打开所有水龙头，你也无法灌溉整个花园。


提示：

1 <= n <= 104
ranges.length == n + 1
0 <= ranges[i] <= 100
"""
from typing import List


class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        ranges_area = []
        for i in range(len(ranges)):
            ranges_area.append([i - ranges[i], i + ranges[i]])

        ranges_area = sorted(ranges_area, key=lambda x: (x[0], -x[1]))

        left = 0
        max_right = 0
        index = 0
        count = 0

        while index < len(ranges_area):
            get_move = False
            while index < len(ranges_area) and ranges_area[index][0] <= left:
                get_move = True
                if ranges_area[index][1] > max_right:
                    max_right = ranges_area[index][1]
                index += 1

            if not get_move:
                return -1

            count += 1
            if max_right >= n:
                return count
            left = max_right
            max_right = 0

            print(count, left)

        return -1


if __name__ == '__main__':
    s = Solution()
    # print(s.minTaps(5, [3, 4, 1, 1, 0, 0]))
    # print(s.minTaps(3, [0, 0, 0, 0]))
    print(s.minTaps(97,
                    [1, 5, 3, 1, 4, 5, 5, 1, 2, 0, 2, 2, 4, 3, 0, 0, 1, 4, 5, 5, 0, 3, 5, 1, 1, 0, 0, 0, 4, 1, 1, 1, 0,
                     4, 4, 1, 0, 0, 2, 5, 5, 4, 4, 4, 2, 4,
                     3, 4, 4, 2, 3, 4, 0, 2, 0, 1, 0, 4, 2, 3, 0, 0, 0, 1, 5, 2, 0, 2, 4, 4, 3, 3, 0, 0, 3, 1, 1, 1, 4,
                     2, 5, 2, 3, 1, 0, 1, 0, 2, 4, 3, 4, 0, 2, 4, 1, 1, 2, 5]))
