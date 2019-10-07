package t1;

import t1.TreeNode;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月26日
 */
public class T35_Solution {
	int maxNum = 0;

	public int maxPathSum(TreeNode root) {
		maxNum = Integer.MIN_VALUE;
		recursionMax(root);
		return maxNum;
	}

	private int recursionMax(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = Math.max(0, recursionMax(node.left));
		int right = Math.max(0, recursionMax(node.right));
		maxNum = Math.max(maxNum, left + right + node.val);
		return Math.max(right, left) + node.val;
	}

}
