package t19;

import java.util.ArrayList;

import t14.TreeNode;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月15日
 */
public class T19_Solution_1 {
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		
		ArrayList<TreeNode> arr = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		while(!arr.contains(root)) {
			list.add(iteration(root, arr).val);
		}
		return list;
	}
	private TreeNode iteration(TreeNode node , ArrayList<TreeNode> arr){

		if(node.left != null && !arr.contains(node.left)) {
			return iteration(node.left , arr);
		}else if(node.right != null && !arr.contains(node.right)){
			return iteration(node.right , arr);
		}else {
			arr.add(node);
			return node;
		}		
	}

}
