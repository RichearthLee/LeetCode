package t38;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yukunlee
 * @Description Given a triangle, find the minimum path sum from top to bottom.
 *              Each step you may move to adjacent numbers on the row below.
 * @date 2018年10月29日
 */
public class T38_Solution {
	/**
	 * @author yukunlee
	 * @Description DP动态规划,改变了输入
	 * @date 2018年10月29日
	 * @param triangle
	 * @return
	 */
	public int minimumTotal_1(ArrayList<ArrayList<Integer>> triangle) {
		for (int i = triangle.size() - 2; i >= 0; --i) {
			int len = triangle.get(i).size();
			for (int j = 0; j < len; ++j) {
				triangle.get(i).set(j,triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}

	/**
	 * @author yukunlee
	 * @Description DP动态规划，不改变输入
	 * @date 2018年10月29日
	 * @param triangle
	 * @return
	 */
	public int minimumTotal_2(ArrayList<ArrayList<Integer>> triangle) {
		ArrayList<Integer> res = new ArrayList<>(triangle.get(triangle.size()-1));
		for (int i = triangle.size() - 2; i >= 0; --i) {
			int len = triangle.get(i).size();
			for (int j = 0; j < len; ++j) {
				res.set(j, triangle.get(i).get(j) + Math.min(res.get(j), res.get(j + 1)))  ;
			}
		}
		return res.get(0);
	}

	/**
	 * @author yukunlee
	 * @Description DFS recursion
	 * @date 2018年10月29日
	 * @param triangle
	 * @return
	 */
	public int minimumTotal_3(ArrayList<ArrayList<Integer>> triangle) {
		return DFS(triangle, 0, 0);
	}
	private int DFS(ArrayList<ArrayList<Integer>> triangle , int i , int j) {
		return i == triangle.size()-1? triangle.get(i).get(j):triangle.get(i).get(j)+ Math.min(DFS(triangle , i+1 ,j), DFS(triangle, i+1 ,j+1));
	}

	/**
	 * @author yukunlee
	 * @Description DFS traverse
	 * @date 2018年10月29日
	 * @param triangle
	 * @return
	 */
	public int minimumTotal_4(ArrayList<ArrayList<Integer>> triangle) {
		Stack<Integer> st = new Stack<>();
		int i = 0 , j = 0, sum = 0, len = triangle.size();
		st.push(triangle.get(i).get(j));
		sum += triangle.get(i).get(j);
		while(!st.isEmpty()) {
			if(i == len-1) {
				
			}
			st.push(triangle.get(i+1).get(j));
			sum += triangle.get(i+1).get(j);
			
			
		}

		return 0;
	}

}
