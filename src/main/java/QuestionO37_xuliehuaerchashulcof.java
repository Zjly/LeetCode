/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */

public class QuestionO37_xuliehuaerchashulcof {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(4);

		Codec codec = new Codec();
		String s = codec.serialize(root);
		TreeNode t = codec.deserialize(s);
		System.out.println(t);
	}
}

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
	StringBuilder stringBuilder = new StringBuilder();
	int index = 0;

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) {
			return "";
		}
		preorderTraversal(root);
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("|");
		inorderTraversal(root);
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}

	public void preorderTraversal(TreeNode root) {
		if(root != null) {
			root.val = root.val + index + 10000;
			stringBuilder.append(root.val);
			index += 100000;
			stringBuilder.append(",");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	public void inorderTraversal(TreeNode root) {
		if(root != null) {
			inorderTraversal(root.left);
			stringBuilder.append(root.val);
			stringBuilder.append(",");
			inorderTraversal(root.right);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals("")) {
			return null;
		}

		String[] s = data.split("\\|");
		String[] preorderS = s[0].split(",");
		String[] inorderS = s[1].split(",");

		return getTree(preorderS, inorderS, 0, preorderS.length - 1, 0, inorderS.length - 1);
	}

	public TreeNode getTree(String[] preorderS, String[] inorderS, int pLeft, int pRight, int iLeft, int iRight) {
		if(pLeft > pRight) {
			return null;
		}

		if(pLeft == pRight) {
			int val = (Integer.parseInt(preorderS[pLeft]) - 10000) % 100000;
			if(val > 1000) {
				val -= 100000;
			}
			return new TreeNode(val);
		}

		String mid = preorderS[pLeft];
		int spiltIndex = -1;
		for(int i = iLeft; i <= iRight; i++) {
			if(inorderS[i].equals(mid)) {
				spiltIndex = i;
				break;
			}
		}

		int val = (Integer.parseInt(mid) - 10000) % 100000;
		if(val > 1000) {
			val -= 100000;
		}
		TreeNode root = new TreeNode(val);
		root.left = getTree(preorderS, inorderS, pLeft + 1, pLeft + spiltIndex - iLeft, iLeft, spiltIndex - 1);
		root.right = getTree(preorderS, inorderS, pLeft + spiltIndex - iLeft + 1, pRight, spiltIndex + 1, iRight);

		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
