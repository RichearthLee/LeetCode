package t1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author yukunlee
 * @Description clone graph
 * @date 2018年10月16日
 */
public class T29_Solution {
	/**
	 * @author yukunlee
	 * @Description DFS for traversing graph
	 * @date 2018年10月16日
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return DFS(node, map);
	}

	private UndirectedGraphNode DFS(UndirectedGraphNode root, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (root == null) {
			return null;
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(root.label);
		map.put(root, clone);
		for (UndirectedGraphNode node : root.neighbors) {
			if (map.containsKey(node)) {
				clone.neighbors.add(map.get(node));
			} else {
				clone.neighbors.add(DFS(node, map));
			}
		}

		return clone;
	}

	/**
	 * @author yukunlee
	 * @Description BFS for traversing graph
	 * @date 2018年10月16日
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		queue.offer(node);
		UndirectedGraphNode cloneroot = new UndirectedGraphNode(queue.element().label);
		map.put(node, cloneroot);
		while (!queue.isEmpty()) {
			for (UndirectedGraphNode n : queue.element().neighbors) {
				if (map.containsKey(n)) {
					map.get(queue.element()).neighbors.add(map.get(n));
				}else {
					queue.offer(n);
					UndirectedGraphNode clone = new UndirectedGraphNode(n.label);
					map.put(n, clone);
					map.get(queue.element()).neighbors.add(clone);
				}
			}
			queue.poll();
		}
		return cloneroot;
	}
}
