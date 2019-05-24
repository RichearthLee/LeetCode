package t1;

import java.util.*;

public class T1_Solution {
	
	/**
	 * @author yukunlee
	 * @Description Dijkstra-algorithm 迪杰斯特拉算法 
	 * @date 2018年12月11日
	 * @param times
	 * @param N
	 * @param K
	 * @return
	 */
	public int[] DijkstraAlgorithm(int[][] times, int N, int K) {
		Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
		for (int[] edge : times) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
		}
		//Collection<? extends PriorityQueue<int[]>> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		Stack<PriorityQueue<int[]>> st = new Stack<PriorityQueue<int[]>>();
		//Queue<PriorityQueue<int[]>> queue1 = new LinkedList<PriorityQueue<int[]>>(pq);
		int[] distence = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		
		pq.add(new int[] { 0, K });
		st.push(pq);
		while(!st.isEmpty()) {
			PriorityQueue<int[]> cur_queue = st.peek();
			PriorityQueue<int[]> new_queue = new PriorityQueue<>();
			int flag = 0;
			while(!cur_queue.isEmpty()) {
				int[] cur = cur_queue.poll();
				if (visited[cur[1]])continue;
				visited[cur[1]] = true;
				flag = 1;
				for (int[] next : graph.get(cur[1])) {
					new_queue.offer(new int[] {cur[0]+next[1], next[0] });
					distence[next[0]] = Math.min(cur[0]+next[1], distence[next[0]]);
				}
				break;
			}
			if(flag == 0 ||new_queue.isEmpty()) {
				st.pop();
				continue;
			}
			st.push(new_queue);
		}
		
		return distence;
	}
	
	/**
	 * @author yukunlee
	 * @Description Bellman-Ford algorithm
	 * @date 2018年12月13日
	 * @param times
	 * @param N
	 * @param K
	 * @return
	 */
	public int BellmanFordalgorithm(int[][] times, int N, int K) {
		double[] distence = new double[N];
		Arrays.fill(distence, Double.POSITIVE_INFINITY);
		distence[K-1] = 0;
		for(int i = 0 ; i < N ; ++i) {
			for(int[] edge : times) {
				distence[edge[1]-1] = Math.min(distence[edge[1]-1], distence[0]+edge[2]);
			}
		}
		double res = Double.MIN_VALUE;
		for(double i : distence) {
			res = Math.max(res, i);
		}
		return res == Double.POSITIVE_INFINITY? -1 : (int)res ;
	}

	
	/**
	 * @author yukunlee
	 * @Description  leetcode 743. Network Delay Time apply Dijkstra-algorithm
	 * @date 2018年12月10日
	 * @param times
	 * @param N
	 * @param K
	 * @return
	 */
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
		int[] distence = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		// Queue<Integer> q = new LinkedList<>();
		for (int[] edge : times) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
		}
		Arrays.fill(distence, Integer.MAX_VALUE);
		distence[K] = 0;

		int max = 0;
		pq.add(new int[] { 0, K });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[1];
			if (visited[curNode])
				continue;
			visited[curNode] = true;
			int curDis = cur[0];
			max = curDis;
			--N;
			if (!graph.containsKey(curNode))
				continue;
			for (int[] next : graph.get(curNode)) {
				if (!visited[next[0]] && curDis + next[1] < distence[next[0]]) {
					pq.offer(new int[] { curDis + next[1], next[0] });
					//distence[next[0]] = curDis + next[1];
				}
			}
		}
		return N == 0 ? max : -1;
	}
	
	
    /**
     * @author yukunlee
     * @Description TODO
     * @date 2019年1月15日
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int max = 0;
        for(int i = 0 , j = 0; i < len ; ++i) {
        	char c = s.charAt(i);
        	if(map.containsKey(c)) {
        		j = Math.max(j, map.get(c)+1); 
        	}
        	map.put(c, i);
        	max = Math.max(max, i-j+1);
        }
    	return max;
    }
    
	public void matrix(int n) {
		int[][] mtx = new int[n][n];
		int a = 0;
		int b = n - 1;
		for (int i = 1; i <= n * n; ++i) {
			mtx[a][b] = i;
			System.out.print(a + " ");
			System.out.println(b);
			if ((b == n - 1 || mtx[a][b+1] != 0) && (a < n-1 && mtx[a+1][b] == 0)) {
				++a;
				continue;
			} else if ((a == n - 1 || mtx[a+1][b] != 0) && (b > 0 && mtx[a][b-1] == 0)) {
				--b;
				continue;
			} else if ((b == 0 || mtx[a][b-1] != 0) && (a > 0 && mtx[a-1][b] == 0)) {
				--a;
				continue;
			} else if ((a == 0 || mtx[a-1][b] != 0) && (b < n-1 && mtx[a][b+1] == 0)) {
				++b;
				continue;
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(mtx[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
