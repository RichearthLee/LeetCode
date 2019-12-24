package previous;


/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月15日
 */
public class T17_Solution_1 {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
            return head;
        }
		ListNode  mid =  getMid(head); 
		ListNode midnext = mid.next;
		mid.next = null;
		return mergeList(sortList(head) , sortList(midnext));
	}
	
	public ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public ListNode mergeList(ListNode l1 , ListNode l2) {
		ListNode prehead = new ListNode(0),cur1 = l1, cur2 = l2, cur = prehead;
		while(l1.next != null && l2.next != null) {
			if(cur1.val < cur2.val) {
				cur.next = cur1;
				cur1 = l1.next;
			}
			else {
				cur.next = cur2;
				cur2 = l2.next;
			}
			cur.next = cur1 == null ? cur2 :cur1;
		}
		return prehead;
	}

/*	
 private ListNode mergeSort(ListNode n1, ListNode n2) {
		ListNode preHead = new ListNode(0), cur1 = n1, cur2 = n2, cur = preHead;
		while (cur1 != null && cur2 != null) {
			if (cur1.val < cur2.val) {
				cur.next = cur1;
				cur1 = cur1.next;
			} else {
				cur.next = cur2;
				cur2 = cur2.next;
			}
			cur = cur.next;
		}
		cur.next = cur1 == null ? cur2 : cur1;
		return preHead.next;

	}
	*/
	 private ListNode mergeSort(ListNode n1, ListNode n2) {
			ListNode preHead = new ListNode(0), cur = preHead;
			while (n1 != null && n2 != null) {
				if (n1.val < n2.val) {
					cur.next = n1;
					n1 = n1.next;
				} else {
					cur.next = n2;
					n2 = n2.next;
				}
				cur = cur.next;
			}
			cur.next = n1 == null ? n2 : n1;
			return preHead.next;

		}

}
