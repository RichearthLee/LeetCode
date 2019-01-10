package t18;

import t17.ListNode;

/**
 * @author heave
 *
 */
/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月11日
 */
public class T18_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T18_Solution s = new T18_Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(4);
		l2.next = l1;
		//l3.next = l2;
		
		s.insertionSortList(null);
		
		System.out.println(l1.next);
		System.out.println(l2.next);
		System.out.println(l1);
		System.out.println(l2);
		//System.out.println(l3.next);

	}

}
