package t1;

import java.util.Stack;

import t1.ListNode;


/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年9月27日
 */
public class T21_Solution {
	public void reorderList(ListNode head) {

		if (head == null || head.next == null) {

		} else {
			Stack<ListNode> st = new Stack<>();
			ListNode pos = new ListNode(0);
			ListNode ln = new ListNode(0);

			int count = 0;

			pos = head;

			while (pos != null) {
				st.push(pos);
				pos = pos.next;
				count++;
			}

			boolean b = (count % 2 == 1);
			int half = count / 2;
			pos = head;

			while (count-1 > half) {
				ln = st.pop();
				ln.next = pos.next;
				pos.next = ln;
				pos = ln.next;
				count--;
			}
			if (!b) {
				ln = st.pop();
				pos.next = ln;
				ln.next = null;
			}else {
				pos.next = null;
			}
		}

	}

}
