package previous;

public class T32_Solution {
	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年10月23日
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {
		int sum = 0;		
		return preorderSum(root, sum);
	}
	
	private int preorderSum(TreeNode root , int sum) {
		if(root == null) {
			return 0;
		}
		sum = sum*10 + root.val;
		if(root.left == null & root.right == null) {
			return sum;
		}
		return preorderSum(root.left , sum) + preorderSum(root.right, sum);
	}
}
