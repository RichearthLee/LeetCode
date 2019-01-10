package t21;

import java.util.Stack;

import t17.ListNode;


/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年9月27日
 */
public class T21_Solution_1 {
	public void reorderList(ListNode head) {

		if (head == null || head.next == null) {

		} else {
			Stack<ListNode> st = new Stack<>();
	
			ListNode fast = new ListNode(0);
			ListNode slow = new ListNode(0);

			fast = head;
			slow = head;

			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			
			fast = slow.next;
			slow.next = null;
			slow = fast;
			
			while(slow != null) {
				st.push(slow);
				slow = slow.next;
			}
			
			while(head != null && !st.empty()) {
				fast = st.pop();
				fast.next = head.next;
				head.next = fast;
				head = fast.next;
			}

		
		}

	}

}
