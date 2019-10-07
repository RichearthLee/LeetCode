package t1;

import java.util.ArrayList;

import t1.TreeNode;

public class T42_Solution {
	/**
	 * @author yukunlee
	 * @Description path-sum
	 * @date 2018年10月31日
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		return root == null ? false : recursion(root, sum, 0);
	}

	private boolean recursion(TreeNode root, int sum, int count) {
		if (root == null) {
			return  false;
		}
		if(root.left == null && root.right == null) {
			count += root.val;
			return sum == count ? true : false;
		}
		count += root.val;
		return recursion(root.left, sum, count) || recursion(root.right, sum, count);

	}
	
    /**
     * @author yukunlee
     * @Description path-sum-ii
     * @date 2018年11月1日
     * @param root
     * @param sum
     * @param count
     * @param li
     * @return
     */
	private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<Integer> li = new ArrayList<>();
    	recursion(root, sum, 0, li);
		return res;
    }
    public ArrayList<Integer> recursion(TreeNode root, int sum, int count, ArrayList<Integer> li ) {
		if (root == null) {
			return  li;
		}
		if(root.left == null && root.right == null) {
			count += root.val;
			if(sum == count) {
				li.add(root.val);
				res.add(new ArrayList<>(li));
				li.remove(li.size()-1);
			}
			return li;
		}
		count += root.val;
		li.add(root.val);
		recursion(root.left, sum, count, li);
		recursion(root.right, sum, count, li);
		li.remove(li.size()-1);

		return li;
    }

}
