import java.util.Arrays;

/**
 * 1707. 与数组中元素的最大异或值
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * <p>
 * 示例 2：
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 * <p>
 * 提示：
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 */

public class Question1707_MaximumXORWithAnElementFromArray {
	public static void main(String[] args) {
		Solution1707 solution1707 = new Solution1707();
		int[] nums = {0, 1, 3};
		int[][] queries = {{5, 2}};
		System.out.println(Arrays.toString(solution1707.maximizeXor(nums, queries)));
	}
}

class Solution1707 {
	public int[] maximizeXor(int[] nums, int[][] queries) {
		Trie trie = new Trie();
		for(int num : nums) {
			trie.add(num);
		}

		int[] result = new int[queries.length];
		for(int i = 0; i < queries.length; i++) {
			int max = trie.search(queries[i][0], queries[i][1]);
			if(max == -1) {
				result[i] = max;
			} else {
				result[i] = queries[i][0] ^ max;
			}
		}

		return result;
	}

	static class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		public void add(int num) {
			TrieNode p = root;
			for(int i = 31; i >= 0; i--) {
				int k = (num >> i) & 1;
				if(k == 0) {
					if(p.left == null) {
						p.left = new TrieNode();
					}
					p = p.left;
				} else {
					if(p.right == null) {
						p.right = new TrieNode();
					}
					p = p.right;
				}
			}
		}

		public int search(int query, int max) {
			TrieNode p = root;
			int num = 0;
			boolean needMax = true;

			// 回溯点
			int backI = -1;
			int backNum = 0;
			TrieNode backP = null;

			for(int i = 31; i >= 0; i--) {
				// query的第K位
				int qK = (query >> i) & 1;
				// max的第K位
				int mK = (max >> i) & 1;
				// query相反的第K位
				int qMaxK = qK ^ 1;

				// 限制向左子树选择(mK == 0)
				if(mK == 0 && needMax) {
					if(p.left != null) {
						p = p.left;
					} else {
						// 无法找到更小的数
						if(backP == null || backP.left == null) {
							return -1;
						} else {
						    i = backI;
						    p = backP.left;
						    num = backNum;
						    needMax = false;
						}
					}
				}
				// 不限制方向(mK == 1)
				else {
					// 想要向左子树选择(qMaxK == 0)
					if(qMaxK == 0) {
						if(p.left != null) {
							needMax = false;
							p = p.left;
						} else {
							p = p.right;
							num += 1 << i;
						}
					}
					// 想要向右子树选择(qMaxK == 1)
					else {
						if(p.right != null) {
							// 设置回溯点
							if(p.left != null) {
								backI = i;
								backNum = num;
								backP = p;
							}

							p = p.right;
							num += 1 << i;
						} else {
							needMax = false;
							p = p.left;
						}
					}
				}
			}

			return num;
		}
	}

	static class TrieNode {
		TrieNode left;
		TrieNode right;

		TrieNode() {

		}
	}
}

