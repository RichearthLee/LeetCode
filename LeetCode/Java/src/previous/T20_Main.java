package previous;

import java.util.ArrayList;
import java.util.Stack;

//import T20_Solution_1;

public class T20_Main {


	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018��9��25��
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(2);
		
		TreeNode n4 = new TreeNode(3);

		
		n1.left = n2;
		n1.right = n3;
		
		Stack<TreeNode> st = new Stack<>();
		st.add(n1);
		st.pop();
		if(st.isEmpty()) {
			System.out.println("nullture");
		}else {
			System.out.println("nullfalse");
		}
//		if(st.empty()) {
//			System.out.println("emptytrue");
//		}
		
		ArrayList<Integer> list = new ArrayList<>();
		T20_Solution_1 s=new  T20_Solution_1();
		list = s.preorderTraversal(n4);
		
		for(Integer o : list) {
			System.out.println(o);
		}

	}

}
