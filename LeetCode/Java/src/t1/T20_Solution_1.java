/**
 * 
 */
package t1;

import java.util.ArrayList;
import java.util.Stack;

import t1.TreeNode;

/**
 * @author yukunlee
 * @Description binary-tree-postorder-traversal of non-recursion(iteration)
 * @date 2018��9��25��
 */
public class T20_Solution_1 {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {

		ArrayList<Integer> arr = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode tn = new TreeNode(0);

		while (!s.empty() || root != null) {
			if (root != null) {
				arr.add(root.val);
				s.push(root);
				root = root.left;
			} else {
				root = s.peek();
				root = root.right;
				if (root != null && root != tn) {
					arr.add(root.val);
					s.push(root);
					root = root.left;
				} else {
					root = s.pop();
					tn = root;
					root = null;
				}
			}
		}

		return arr;
	}
}
