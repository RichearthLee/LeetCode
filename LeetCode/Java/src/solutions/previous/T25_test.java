package solutions.previous;

public class T25_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode n0 = new RandomListNode(0);
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		
		T25_Solution s = new T25_Solution();
		RandomListNode t = s.copyRandomList(n0);
		
		while(t != null) {
			System.out.print(t.label);
			t = t.next;
		}


	}

}
