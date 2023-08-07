/**
 * 421. 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * <p>
 * 示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：nums = [2,4]
 * 输出：6
 * <p>
 * 示例 4：
 * 输入：nums = [8,10,2]
 * 输出：10
 * <p>
 * 示例 5：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 */

public class Question421_MaximumXOROfTwoNumbersInAnArray {
	public static void main(String[] args) {
		int[] nums = {3, 10, 5, 25, 2, 8};
		Solution421 solution421 = new Solution421();
		System.out.println(solution421.findMaximumXOR(nums));
	}
}

class Solution421 {
	public int findMaximumXOR(int[] nums) {
		Trie trie = new Trie();
		for(int num : nums) {
			trie.insert(num);
		}

		int max = 0;

		for(int num : nums) {
			max = Math.max(max, num ^ trie.search(num));
		}
		return max;
	}

	class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(int num) {
			TrieNode p = root;

			String bNum = Integer.toBinaryString(num);
			int addZeroLength = 32 - bNum.length();
			for(int i = 0; i < addZeroLength; i++) {
				if(p.children[0] == null) {
				    p.children[0] = new TrieNode('0');
				}
				p = p.children[0];
			}

			for(int i = 0; i < bNum.length(); i++) {
				char c = bNum.charAt(i);
				if(p.children[c - '0'] == null) {
				    p.children[c - '0'] = new TrieNode(c);
				}
				p = p.children[c - '0'];
			}
		}

		public int search(int num) {
			TrieNode p = root;

			String bNum = Integer.toBinaryString(num);
			int addZeroLength = 32 - bNum.length();

			StringBuffer stringBuffer = new StringBuffer();
			for(int i = 0; i < addZeroLength; i++) {
				if(p.children[1] != null) {
				    stringBuffer.append(1);
				    p = p.children[1];
				} else {
				    stringBuffer.append(0);
				    p = p.children[0];
				}
			}

			for(int i = 0; i < bNum.length(); i++) {
				char c = bNum.charAt(i);
				if(c == '0') {
					if(p.children[1] != null) {
						stringBuffer.append(1);
						p = p.children[1];
					} else {
						stringBuffer.append(0);
						p = p.children[0];
					}
				} else {
					if(p.children[0] != null) {
						stringBuffer.append(0);
						p = p.children[0];
					} else {
						stringBuffer.append(1);
						p = p.children[1];
					}
				}
			}

			return Integer.parseInt(stringBuffer.toString(), 2);
		}
	}

	class TrieNode {
		boolean value;
		TrieNode[] children = new TrieNode[2];

		TrieNode() {

		}

		TrieNode(char c) {
			value = c == '1';
		}
	}
}