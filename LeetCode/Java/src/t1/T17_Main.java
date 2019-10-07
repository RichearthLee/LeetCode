package t1;

import t1.ListNode;
import t1.TreeNode;

public class T17_Main {

	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年10月15日
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode preHead = new ListNode(0),  cur = preHead;
		
		System.out.println(preHead);
		System.out.println(cur);
		
		cur.val = 2;
		
		System.out.println(cur.val);
		System.out.println(preHead.val);
		
		System.out.println("____________________________________________");
		
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(2);
		
		System.out.println(l2.val);
		
		l1= l2;
		
		l1.val = 1;
		
		System.out.println(l2.val);
		
		System.out.println("____________________________________________");
		TreeNode tn = new TreeNode(0);
		TreeNode tn1 = tn;
		
		tn = null;
		
		System.out.println(tn);



	}

}
