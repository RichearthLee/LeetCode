package t19;

import java.util.ArrayList;

import t14.TreeNode;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018Äê9ÔÂ25ÈÕ
 */
public class T19_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(2);
		
		TreeNode n4 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3 ;
		
	/*	T19_Solution s = new T19_Solution();
		ArrayList<Integer> arr = s.postorderTraversal(n1);
		*/
		ArrayList<TreeNode> t = new ArrayList<>();
		t.add(n3);
		t.contains(n1);
		
		T19_Solution_1 s = new T19_Solution_1();
		ArrayList<Integer> arr = s.postorderTraversal(n1);

		for(Integer o : arr) {
			System.out.println(o);
		}
	}

}
