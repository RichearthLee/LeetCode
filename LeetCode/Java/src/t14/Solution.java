package t14;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along 
 * the shortest path from the root node down to the nearest leaf node.
 */

public class Solution {
	public int run(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int dept = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int len = queue.size();
			dept++;
			for (int i = 0; i < len; i++) {
				TreeNode cur = queue.poll();
				if (cur.left == null && cur.right == null) {
					return dept;
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
		}

		return 0;
	}

}
