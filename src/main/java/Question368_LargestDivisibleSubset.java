import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 */

public class Question368_LargestDivisibleSubset {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Solution368 solution368 = new Solution368();
		List<Integer> list = solution368.largestDivisibleSubset(nums);
		System.out.println(list);
	}
}

class Solution368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		Node root = new Node();
		Arrays.sort(nums);

		Node maxLevelNode = new Node();

		for(int num : nums) {
			Node p = insert(root, num, 1);
			if(p.level > maxLevelNode.level) {
				maxLevelNode = p;
			}
		}

		ArrayList<Integer> result = new ArrayList<>();

		while(maxLevelNode.level != 0) {
			result.add(maxLevelNode.num);
			maxLevelNode = maxLevelNode.parent;
		}

		return result;
	}

	private Node insert(Node root, int num, int level) {
		boolean isInsert = false;
		Node maxLevelNode = new Node();
		for(int i = 0; i < root.children.size(); i++) {
			Node child = root.children.get(i);
			if(num % child.num == 0) {
				isInsert = true;
				Node p = insert(child, num, level + 1);
				if(p.level > maxLevelNode.level) {
					maxLevelNode = p;
				}
			}
		}

		if(!isInsert) {
			Node p = new Node(num, level);
			p.parent = root;
			root.children.add(p);
			if(p.level > maxLevelNode.level) {
				maxLevelNode = p;
			}
		}

		return maxLevelNode;
	}

	class Node {
		int num;
		Node parent;
		int level;
		ArrayList<Node> children = new ArrayList<>();

		Node() {

		}

		Node(int num) {
			this.num = num;
		}

		public Node(int num, int level) {
			this.num = num;
			this.level = level;
		}

		@Override
		public String toString() {
			return String.valueOf(num);
		}
	}
}





