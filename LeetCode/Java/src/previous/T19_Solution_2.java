package previous;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yukunlee
 *
 */
public class T19_Solution_2 {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {

		ArrayList<Integer> arr = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode tn = new TreeNode(0);

		while (!s.empty() || root != null) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				root = s.peek();
				root = root.right;
				if (root != null && root != tn) {
					s.push(root);
					root = root.left;
				} else {
					root = s.pop();
					arr.add(root.val);
					tn = root;
					root = null;
				}
			}
		}

		return arr;
	}

}
