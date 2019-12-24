package previous;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月11日
 */
public class T18_Solution {
	public ListNode insertionSortList(ListNode head) {


		ListNode list = new ListNode(Integer.MIN_VALUE);
		ListNode cur = new ListNode(Integer.MIN_VALUE);
		


		while (head != null) {
			cur = head;
			head = head.next;

			list.next = insert(list.next, cur);
		}
		return list.next;
	}

	public ListNode insert(ListNode head, ListNode n) {
		ListNode prehead = head;
		if( head == null) {
			n.next = null;
			return n;
		}
       if(n.val <= head.val) {
    	   n.next = head;
    	   return n;
       }
			
		while (head.next != null) {		
			if (n.val <= head.next.val) {
				n.next = head.next;
				head.next = n;
				break;		
				}
			head = head.next;
		}
		if(head.next == null) {
			head.next = n;
			n.next = null;
		}
			return prehead;
		

	}

}
