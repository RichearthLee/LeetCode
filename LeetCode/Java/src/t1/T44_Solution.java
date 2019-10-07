package t1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import t1.TreeNode;

public class T44_Solution {
	/**
	 * @author yukunlee
	 * @Description binary-tree-level-order-traversal
	 * @date 2018年11月2日
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if( root == null) {
			return res;
		}
		ArrayList<Integer> list;
		int size = 0;
		TreeNode node;
		queue.offer(root);
		while (!queue.isEmpty()) {
			size = queue.size();
			list = new ArrayList<>();
			while (size != 0) {
				node = queue.poll();
				list.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
				--size;
			}
			res.add(list);
		}
		return res;
	}

    /**
     * @author yukunlee
     * @Description binary-tree-level-order-traversal-ii
     * @date 2018年11月2日
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if( root == null) {
			return res;
		}
		ArrayList<Integer> list;
		int size = 0;
		TreeNode node;
		queue.offer(root);
		while (!queue.isEmpty()) {
			size = queue.size();
			list = new ArrayList<>();
			while (size != 0) {
				node = queue.poll();
				list.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
				--size;
			}
			res.add(0, list);
		}
		return res;     
    }
    
}
