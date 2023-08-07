import java.util.ArrayList;
import java.util.List;

/**
 * 1104. 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 * 示例 1：
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * <p>
 * 示例 2：
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 * <p>
 * 提示：
 * 1 <= label <= 10^6
 */

public class Question1104_PathInZigzagLabelledBinaryTree {
	public static void main(String[] args) {
		Solution1104 solution1104 = new Solution1104();
		int label = 14;
		System.out.println(solution1104.pathInZigZagTree(label));
	}
}

class Solution1104 {
	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		String binaryLabel = Integer.toBinaryString(label);

		boolean needReverse = binaryLabel.length() % 2 != 0;

		for(int i = 1; i < binaryLabel.length(); i++) {
			String subBinaryLabel = binaryLabel.substring(0, i + 1);
			if(needReverse) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(subBinaryLabel.charAt(0));
				for(int j = 1; j < subBinaryLabel.length(); j++) {
					if(subBinaryLabel.charAt(j) == '0') {
						stringBuilder.append('1');
					} else {
						stringBuilder.append('0');
					}
				}
				result.add(Integer.parseInt(stringBuilder.toString(), 2));
			} else {
				result.add(Integer.parseInt(subBinaryLabel, 2));
			}
			needReverse = !needReverse;
		}

		return result;
	}
}