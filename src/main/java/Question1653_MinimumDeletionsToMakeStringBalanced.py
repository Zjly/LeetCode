"""
1653. 使字符串平衡的最少删除次数
给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。

你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。

请你返回使 s 平衡 的 最少 删除次数。



示例 1：

输入：s = "aababbab"
输出：2
解释：你可以选择以下任意一种方案：
下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
示例 2：

输入：s = "bbaaaaabb"
输出：2
解释：唯一的最优解是删除最前面两个字符。


提示：

1 <= s.length <= 105
s[i] 要么是 'a' 要么是 'b'​ 。​
"""


class Solution:
    def minimumDeletions(self, s: str) -> int:
        left_b_count = 0
        right_a_count = s.count('a', 1)
        min_delete = right_a_count

        for i in range(1, len(s)):
            if s[i - 1] == 'b':
                left_b_count += 1

            if s[i] == 'a':
                right_a_count -= 1

            min_delete = min(min_delete, left_b_count + right_a_count)

        return min_delete
