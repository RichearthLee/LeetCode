package t45;

import t14.TreeNode;

public class T45_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4};
		int[] b = {1,3,4,2};
		T45_Solution t = new T45_Solution();
		TreeNode n = t.buildTree_1(a, b);
		System.out.println(n.val +"+"+n.left.val+"+"+n.right.val);

	}

}
