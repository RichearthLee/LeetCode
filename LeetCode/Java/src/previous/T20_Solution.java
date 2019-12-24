package previous;

import java.util.ArrayList;

/**
 * @author yukunlee
 * @Description binary-tree-postorder-traversal of recursion
 * @date 2018��9��25��
 */

public class T20_Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null) {
    		return list;
    	}
		list = recursion(root, list);
    	return list;   	
    }
    
    private ArrayList<Integer> recursion(TreeNode root , ArrayList<Integer> list){
    	list.add(root.val);
    	if(root.left != null) {
    		recursion(root.left, list);
    	}
    	if(root.right != null) {
    		recursion(root.right, list);
    	}
		return list;
    }

}
