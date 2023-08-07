import java.util.LinkedList;
import java.util.Queue;

public class Tool {
	/**
	 * 根据数组创建树
	 *
	 * @param nums 待创建树的数组表示 例如[6,3,5,null,2,0,null,null,1]
	 * @return 创建的树的根节点
	 */
	public static TreeNode createTreeFromArray(Integer[] nums) {
		// 树为空
		if(nums.length == 0) {
			return null;
		}

		// 树的根节点
		TreeNode root = new TreeNode(nums[0]);

		// 数组索引
		int index = 1;

		// 层序遍历所储存的队列
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		// 直至队列为空
		while(!queue.isEmpty()) {
			// 对队列中当层节点进行处理
			int queueSize = queue.size();
			for(int i = 0; i < queueSize; i++) {
				// 取出一个节点
				TreeNode p = queue.poll();

				// 节点非空才继续下一步
				if(p != null) {
					// 创建左子树
					if(index < nums.length && nums[index] != null) {
						TreeNode left = new TreeNode(nums[index]);
						p.left = left;
						queue.offer(left);
					}
					index++;

					// 创建右子树
					if(index < nums.length && nums[index] != null) {
						TreeNode right = new TreeNode(nums[index]);
						p.right = right;
						queue.offer(right);
					}
					index++;
				}

				// 已经生成完毕
				if(index >= nums.length) {
					break;
				}
			}
		}

		return root;
	}
}
