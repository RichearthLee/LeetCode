package previous;

public class T29_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode n3 = new UndirectedGraphNode(3);
		
		n1.neighbors.add(n2);
		n2.neighbors.add(n3);

		
		T29_Solution t = new T29_Solution();
		UndirectedGraphNode test = t.cloneGraphBFS(n1);
		System.out.println(test.neighbors.get(0).label);

	}

}
