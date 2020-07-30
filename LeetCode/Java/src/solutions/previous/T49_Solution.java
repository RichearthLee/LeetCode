package solutions.previous;

import java.util.ArrayList;
import java.util.Stack;

public class T49_Solution {
	/**
	 * @author yukunlee
	 * @Description restore-ip-addresses
	 * @date 2018年11月16日
	 * @param s
	 * @return
	 */
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> list = new ArrayList<>();
		int val;
		String ip = "";
		int len = s.length();
		for (int i = 1; i <= 3; ++i) {
			for (int j = i + 1; j <= i + 3; ++j) {
				for (int n = j + 1; n <= j + 3; ++n) {
					ip = "";
					if (len <= n || (len - n) > 3)
						continue;

					val = Integer.parseInt(s.substring(0, i));
					if (val < 0 || val > 255)
						continue;
					ip += val + ".";

					val = Integer.parseInt(s.substring(i, j));
					if (val < 0 || val > 255)
						continue;
					ip += val + ".";

					val = Integer.parseInt(s.substring(j, n));
					if (val < 0 || val > 255)
						continue;
					ip += val + ".";

					val = Integer.parseInt(s.substring(n));
					if (val < 0 || val > 255)
						continue;
					ip += val;

					if (ip.length() < len + 3)
						continue;
					list.add(ip);
				}
			}
		}
		return list;
	}

	/**
	 * @author yukunlee
	 * @Description decode-ways
	 * @date 2018年11月19日
	 * @param s
	 * @return
	 */
	public int numDecodings_1(String s) {
		int len = s.length();
		if (len == 0)
			return 0;
		int count = 0;
		int cur, next;
		for (int i = 0; i < len; ++i) {
			cur = Integer.parseInt(s.substring(i, i + 1));
			if (i + 1 < len) {
				next = Integer.parseInt(s.substring(i + 1, i + 2));
			} else {
				next = -1;
			}
			// c = s.charAt(i);
			if ((cur == 1 || (cur == 2 && next > 0 && next < 7)) && next != -1) {
				++count;
			}
			if (cur == 0) {
				--count;
			}
			if (cur == 0 & next == 0) {
				return 0;
			}
			if (cur == 0 && i == 0) {
				return 0;
			}
		}
		return 1 + count;
	}

	public int numDecodings(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		int[] dp = new int[len + 1];
		if (Integer.parseInt(s.substring(0, 1)) == 0) {
			return 0;
		} else {
			dp[0] = 1;
			dp[1] = 1;
		}
		char c1, c2;
		for (int i = 2; i <= len; ++i) {
			c1 = s.charAt(i - 1);
			c2 = s.charAt(i - 2);
			if (c1 >= '1' && c2 <= '9') {
				dp[i] += dp[i - 1];
			}
			if (c2 == '1' || c2 == '2' && c1 >= '0' && c1 <= '6') {
				dp[i] += dp[i - 2];
			}
		}

		return dp[len];
	}

	/**
	 * @author yukunlee
	 * @Description grayCode
	 * @date 2018年11月19日
	 * @param n
	 * @return
	 */
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int num = 1 << n;
		for (int i = 0; i < num; ++i) {
			arr.add(i >> 1 ^ i);
		}
		return arr;
	}

	public ArrayList<Integer> grayCode_v1(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		int bits = 0;
		int len;
		for (int i = 0; i < n; ++i) {
			bits = 1 << i;
			len = arr.size();
			for (int j = len - 1; j >= 0; --j) {
				arr.add(arr.get(j) | bits);
			}
		}
		return arr;
	}

	/**
	 * @author yukunlee
	 * @Description scramble-string
	 * @date 2018年11月20日
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		if (s1.length() != s2.length())
			return false;
		int len = s1.length();
		int[] letter = new int[26];
		for (int i = 0; i < len; ++i) {
			letter[s1.charAt(i) - 'a']++;
			letter[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; ++i) {
			if (letter[i] != 0)
				return false;
		}

		for (int i = 1; i < len; ++i) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
				return true;
			}
			if (isScramble(s1.substring(0, i), s2.substring(len - i))
					&& isScramble(s1.substring(i), s2.substring(0, len - i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @author yukunlee
	 * @Description partition-list
	 * @date 2018年11月20日
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode pre = null, post = head, cur = head;
		while (cur != null) {
			if (cur.val >= x) {
				break;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}

		if (pre != null) {
			cur = pre.next;
		}

		while (cur != null) {
			if (cur.val < x) {
				post.next = cur.next;
				if (pre != null) {
					cur.next = pre.next.next;
					pre.next = cur;
					pre = pre.next;
				} else {
					cur.next = head;
					pre = cur;
					head = cur;
				}
			} else {
				post = cur;
			}
			cur = cur.next;
		}
		return head;
	}

	/**
	 * @author yukunlee
	 * @Description largest-rectangle-in-histogram
	 * @date 2018年11月21日
	 * @param height
	 * @return
	 */
	public int largestRectangleArea_v1(int[] height) {
		return helper(height, 0, height.length - 1);
	}

	private int helper(int[] height, int head, int tail) {
		if (head > tail) {
			return 0;
		}
		int min = head;
		for (int i = head; i <= tail; ++i) {
			if (height[i] < height[min]) {
				min = i;
			}
		}
		return Math.max((tail - head + 1) * height[min],
				Math.max(helper(height, head, min - 1), helper(height, min + 1, tail)));
	}

	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年11月21日
	 * @param height
	 * @return
	 */
	public int largestRectangleArea(int[] height) {
		if (height.length <= 0) {
			return 0;
		}
		Stack<Integer> st = new Stack<>();
		int count = 0;
		int res = 0;
		st.push(height[0]);
		for (int i = 1; i <= height.length - 1; ++i) {
			if (st.peek() <= height[i]) {
				st.push(height[i]);
			} else {
				count = 0;
				while (!st.isEmpty() && st.peek() > height[i]) {
					count++;
					res = Math.max(res, st.pop() * count);
				}
				++count;
				while (count != 0) {
					st.push(height[i]);
					--count;
				}
			}
		}
		for (int i = 1; i <= height.length; ++i) {
			res = Math.max(res, st.pop() * i);
		}
		return res;
	}

	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年11月21日
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length;
		int res = 0;
		int[] height = new int[n];
		for (int r = 0; r < m; ++r) {
			Stack<Integer> st = new Stack<>();
			int count = 0;
			for (int i = 0; i < n; ++i) {
				if (matrix[r][i] == '1') {
					height[i]++;
				} else {
					height[i] = 0;
				}
			}
			st.push(height[0]);
			for (int i = 1; i <= height.length - 1; ++i) {
				if (st.peek() <= height[i]) {
					st.push(height[i]);
				} else {
					count = 0;
					while (!st.isEmpty() && st.peek() > height[i]) {
						count++;
						res = Math.max(res, st.pop() * count);
					}
					++count;
					while (count != 0) {
						st.push(height[i]);
						--count;
					}
				}
			}
			for (int i = 1; i <= height.length; ++i) {
				res = Math.max(res, st.pop() * i);
			}
		}

		return res;
	}

	/**
	 * @author yukunlee
	 * @Description remove-duplicates-from-sorted-list
	 * @date 2018年11月21日
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates_v1(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = head, post = head, cur = head.next;
		while (cur != null) {
			if (pre.val == cur.val) {
				pre.next = cur.next;
				post = cur;
				cur = cur.next;
				post.next = null;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}

	/**
	 * @author yukunlee
	 * @Description remove-duplicates-from-sorted-list-ii
	 * @date 2018年11月22日
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode pre = null, post, cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val != cur.next.val) {
				pre = cur;
				cur = cur.next;
			} else {
				while (cur.next != null && cur.val == cur.next.val) {
					cur = cur.next;
				}
				if (pre == null) {
					head = cur.next;
					cur = head;
				} else {
					post = cur;
					pre.next = cur.next;
					cur = pre.next;
					post.next = null;
				}
			}
		}
		return head;
	}

	/**
	 * @author yukunlee
	 * @Description search-in-rotated-sorted-array
	 * @date 2018年11月22日
	 * @param A
	 * @param target
	 * @return
	 */
	public int search_v1(int[] A, int target) {
		for (int i = 0; i < A.length; ++i) {
			if (A[i] == target) {
				return i;
			} else {
				if (i > 0 && A[i] > target && A[i - 1] < target) {
					return -1;
				}
			}
		}
		return -1;
	}

	// 折半查找
	public int search(int[] A, int target) {
		int head = 0, tail = A.length - 1;

		while (head <= tail) {
			int mid = head + (tail - head) / 2;
			if (mid == target) {
				return mid;
			}
			if (A[head] <= A[mid])// 左边有序
			{
				if (A[head] <= target && target < A[mid])
					tail = mid - 1;
				else
					head = mid + 1;
			} else// 右边有序
			{
				if (A[mid] < target && target <= A[tail])
					head = mid + 1;
				else
					tail = mid - 1;

			}
		}

		return -1;
	}

	/**
	 * @author yukunlee
	 * @Description remove-duplicates-from-sorted-array
	 * @date 2018年11月23日
	 * @param A
	 * @return
	 */
	public int removeDuplicates_v1(int[] A) {
		if (A.length <= 0)
			return 0;
		int res = 1;
		for (int i = 1; i < A.length; ++i) {
			if (A[i - 1] != A[i]) {
				A[res++] = A[i];
			}
		}
		return res;
	}

	/**
	 * @author yukunlee
	 * @Description remove-duplicates-from-sorted-array II
	 * @date 2018年11月23日
	 * @param A
	 * @return
	 */
	public int removeDuplicates(int[] A) {
		if (A.length <= 0)
			return 0;
		int res = 1;
		int count = 0;
		for (int i = 1; i < A.length; ++i) {
			if (A[i - 1] != A[i]) {
				A[res++] = A[i];
				count = 0;
			} else {
				++count;
				if (count <= 1) {
					A[res++] = A[i];
				}
			}
		}
		return res;
	}

	/**
	 * @author yukunlee
	 * @Description word-search
	 * @date 2018年11月25日
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (DFS(board, word, i, j, 0))
					return true;
			}
		}
		return false;
	}

	private boolean DFS(char[][] board, String word, int i, int j, int index) {
		if (index >= word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
			return false;
		}

		board[i][j] ^= 512;
		boolean flag = DFS(board, word, i - 1, j, index + 1) || DFS(board, word, i + 1, j, index + 1)
				|| DFS(board, word, i, j - 1, index + 1) || DFS(board, word, i, j + 1, index + 1);
		board[i][j] ^= 512;
		return flag;
	}


	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年11月25日
	 * @param n
	 * @param k
	 * @return
	 */
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		if (n <= 0 || k <= 0 || n < k)
            return res;
		ArrayList<Integer> list = new ArrayList<>();
		helper(list, 1, n, k);
		return res;
	}

	private void helper(ArrayList<Integer> list, int index, int n, int k) {
		if (0 == k) {
			res.add(new ArrayList<>(list));
			return;
		}
		if (index > n) {
			return;
		}
		for (int i = index; i <= n - k + 1; ++i) {
			list.add(i);
			helper(list, i + 1, n, k-1);
			list.remove(list.size() - 1);
		}
		return;
	}

	
	
	public ArrayList<ArrayList<Integer>> combine_v1(int n, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		helper_v1(list, 1, n, k);
		return res;
	}

	private void helper_v1(ArrayList<Integer> list, int index, int n, int k) {
		if (0 == k) {
			res.add(new ArrayList<>(list));
			return;
		}
		if (index > n) {
			return;
		}
		list.add(index);
		helper(list, index + 1, n, k-1);
		list.remove(list.size() - 1);

		helper(list, index + 1, n, k);
		return;
	}

}
