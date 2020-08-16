package solutions.previous;

import java.util.ArrayList;

/**
 * @author yukunlee
 *
 */
public class T19_Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> list = new ArrayList<>();
		
		if(root != null) {
			return recursion(root, list);
		}
		else {
			return list;
		}
		
	}
	
	private ArrayList<Integer>  recursion(TreeNode root , ArrayList<Integer> list) {
		if(root.left != null) {
			recursion(root.left, list) ;
		}
		if(root.right != null) {
			recursion(root.right, list) ;
		}		
		list.add(root.val);
		
		return list;		
	}
	

}
