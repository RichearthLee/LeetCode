package previous;

/**
 * @author yukunlee
 * @Description A linked list is given such that each node contains an additional random 
 * pointer which could point to any node in the list or null.Return a deep copy of the list.
 * @date 2018年10月6日
 */
public class T25_Solution {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode copy = null, i , newhead;
		for (i = head; i != null; i = i.next) {
			copy = new RandomListNode(i.label);
			copy.next = i.next;
			i = i.next = copy;
		}

		for (i = head; i != null; i = copy.next) {
			copy = i.next;
			copy.random = (i.random != null ? i.random.next : null);
		}		

		newhead = head.next;
		for(i = head ; i != null ;i = i.next) {
			copy = i.next;
			i.next = copy.next;
			copy.next = (i.next == null ? null : i.next.next);
		}

		return newhead;
	}
}
