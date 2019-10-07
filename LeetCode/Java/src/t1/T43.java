package t1;

import t1.TreeNode;

public class T43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 9;
		System.out.println(8>>1);
		
		TreeNode n1 =new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;
		System.out.println("origial-----"+n1.left.val);
		test(n1);
		System.out.println("MainAPP----"+ n1.left +"-----"+ n1.val);
		System.out.println(test1(n1).left);
		
		String s1 = "a";
		System.out.println(s1);
		test2(s1);
		System.out.println(s1.hashCode());
		System.out.println(test3(s1));
		System.out.println(s1);
		
		Integer b = 1;
		test4(b);
		System.out.println(b);


	}
	static void test4(int b ) {
		b =2;
		System.out.println(b);
	}
	static void test2(String s ) {
		System.out.println(s.hashCode());
		s = "b";
	}
	static String test3(String s ) {
		return s = "b";
	}
	
	static void test(TreeNode n) {
		n.left = null;
		n.val = 0;
		System.out.println("MainAPP----------"+n.left+"---"+ n.val);
	}
	static TreeNode test1(TreeNode n) {
		n.left = null;
		System.out.println("TestMethod----------"+n.left);
		return n;
	}

}
