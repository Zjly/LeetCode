"""
面试题 17.05.  字母与数字
给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。

返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。

示例 1:

输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]

输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
示例 2:

输入: ["A","A"]

输出: []
提示：

array.length <= 100000
"""
from typing import List


class Solution:
    def findLongestSubarray(self, array: List[str]) -> List[str]:
        dp = [0] * (len(array) + 1)
        for i in range(0, len(array)):
            dp[i + 1] = dp[i] + (0 if array[i].isdigit() else 1)

        hashmap = {}
        max_len = 0
        left = 0
        for i in range(len(dp)):
            n = i - 2 * dp[i]
            if n in hashmap:
                j = hashmap[n]
                if i - j > max_len:
                    max_len = i - j
                    left = j
            else:
                hashmap[n] = i

        return array[left:left + max_len]


if __name__ == '__main__':
    s = Solution()
    # print(s.findLongestSubarray(
    #     ["A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"]))
    print(s.findLongestSubarray(
        ["42", "10", "O", "t", "y", "p", "g", "B", "96", "H", "5", "v", "P", "52", "25", "96", "b", "L", "Y", "z", "d",
         "52", "3", "v", "71", "J", "A", "0", "v", "51", "E", "k", "H", "96", "21", "W", "59", "I", "V", "s", "59", "w",
         "X", "33", "29", "H", "32", "51", "f", "i", "58", "56", "66", "90", "F", "10", "93", "53", "85", "28", "78",
         "d", "67", "81", "T", "K", "S", "l", "L", "Z", "j", "5", "R", "b", "44", "R", "h", "B", "30", "63", "z", "75",
         "60", "m", "61", "a", "5", "S", "Z", "D", "2", "A", "W", "k", "84", "44", "96", "96", "y", "M"]))
