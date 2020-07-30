package solutions.previous;

/**
 * @author yukunlee
 * @Description Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * @date 2018年9月28日
 */
public class T22_Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
