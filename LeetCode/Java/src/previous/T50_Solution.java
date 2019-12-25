package previous;

import java.util.*;

public class T50_Solution {
	/**
	 * @author yukunlee
	 * @Description minimum-window-substring
	 * @date 2018年11月26日
	 * @param S
	 * @param T
	 * @return
	 */
	public String minWindow(String S, String T) {
		int head = 0, tail = 0, slen = S.length(), tlen = T.length(), count = tlen, d = Integer.MAX_VALUE, start = 0;
		Map<Character, Integer> map = new HashMap<>(30, 0.75f);
		char ch;

		for (int i = 0; i < tlen; ++i) {
			if (map.containsKey(T.charAt(i))) {
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			} else {
				map.put(T.charAt(i), 1);
			}
			// map.put(T.charAt(i),map.containsKey(T.charAt(i))?map.get(T.charAt(i))+1:1);
		}

		/*
		 * for (char c : T.toCharArray()) { if (!map.containsKey(c)) map.put(c, 0);
		 * map.put(c, map.get(c) + 1); }
		 */

		/*
		 * S ="ADOBECODEBANC"; T ="ABC";
		 */
		while (tail < slen) {
			ch = S.charAt(tail++);
			if (map.containsKey(ch)) {
				if (map.get(ch) > 0) {
					count--;
				}
				map.put(ch, map.get(ch) - 1);
			}
			while (count == 0) {
				if (tail - head < d) {
					d = tail - (start = head);
				}
				ch = S.charAt(head++);
				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) + 1);
					if (map.get(ch) > 0) {
						count++;
					}
				}
			}
		}
		return d == Integer.MAX_VALUE ? "" : S.substring(start, start + d);
	}

	/**
	 * @author yukunlee
	 * @Description sort-colors
	 * @date 2018年11月26日
	 * @param A
	 */
	public void sortColors(int[] A) {
		int one = 0, two = A.length - 1;

		for (int i = 0; i <= two; ++i) {
			if (A[i] < 1) {
				A[i] = A[one];
				A[one] = 0;
				++one;
			} else if (A[i] > 1) {
				A[i] = A[two];
				A[two] = 2;
				--two;
				--i;
			}
		}
	}

	/**
	 * @author yukunlee
	 * @Description search-a-2d-matrix
	 * @date 2018年11月27日
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix_v1(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; ++i) {
			if (matrix[i][0] > target) {
				if (i - 1 < 0)
					return false;
				for (int j = 0; j < matrix[0].length; ++j) {
					if (matrix[i - 1][j] == target)
						return true;
				}
				break;
			}
		}
		if (matrix[matrix.length - 1][matrix[0].length - 1] < target) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (matrix[matrix.length][j] == target)
					return true;
			}
		}
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (target == matrix[row][col])
				return true;
			else if (target < matrix[row][col]) {
				--col;
			} else if (target > matrix[row][col]) {
				++row;
			}
		}
		return false;
	}

	/**
	 * @author yukunlee
	 * @Description set-matrix-zeroes
	 * @date 2018年11月27日
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
		HashSet<Integer> row = new HashSet<>();
		HashSet<Integer> col = new HashSet<>();

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}

		for (Integer i : row) {
			for (int j = 0; j < matrix[0].length; ++j) {
				matrix[i][j] = 0;
			}
		}

		for (Integer i : col) {
			for (int j = 0; j < matrix.length; ++j) {
				matrix[j][i] = 0;
			}
		}

	}

	/**
	 * @author yukunlee
	 * @Description edit-distance
	 * @date 2018年11月27日
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		char[] s1 = word1.toCharArray();
		char[] s2 = word2.toCharArray();
		int len1 = s1.length, len2 = s2.length;
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; ++i) {
			for (int j = 0; j <= len2; ++j) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1),
							dp[i - 1][j - 1] + (s1[i - 1] == s2[j - 1] ? 0 : 1));
				}

			}
		}
		return dp[len1][len2];
	}

	/**
	 * @author yukunlee
	 * @Description simplify-path
	 * @date 2018年11月28日
	 * @param path
	 * @return
	 */
	public String simplifyPath(String path) {
		Stack<String> st = new Stack<>();
		String[] str = path.split("/");
		for (String s : str) {
			if (!st.isEmpty() && s.equals("..")) {
				st.pop();
			} else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
				st.push(s);
			}
		}
		// List<String> list = new ArrayList<>(st);
		return "/" + String.join("/", st);
	}

	/**
	 * @author yukunlee
	 * @Description climbing-stairs
	 * @date 2018年11月28日
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n + 1; ++i) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	/**
	 * @author yukunlee
	 * @Description sqrtx 牛顿逼近法
	 * @date 2018年11月28日
	 * @param x
	 * @return
	 */
	public int sqrt(int x) {
		long n = x, a, b, c;
		while (n * n > x) {
			/*
			 * a = (n*n-x); b = (n<<1); c = Math.round((float)a/b); n = n - c;
			 */
			n = (n + x / n) >> 1;
		}
		return (int) n;
	}

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; --i) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				break;
			}
		}
		if (digits[0] == 0) {
			int[] arr = new int[digits.length + 1];
			arr[0] = 1;
			return arr;
		}
		return digits;
	}

	/**
	 * @author yukunlee
	 * @Description text-justification
	 * @date 2018年12月3日
	 * @param words
	 * @param L
	 * @return
	 */
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<>();
		if (words.length == 0 || L == 0) {
			result.add("");
			return result;
		}
		Queue<String> mid = new LinkedList<>();
		int count = 0, num = 0, blank = 0, mod = 0;
		for (int i = 0; i <= words.length; ++i) {
			if (i != words.length && (count + words[i].length()) <= L - mid.size()) {
				count += words[i].length();
				mid.add(words[i]);
				continue;
			} else if (count != 0 && mid.size() > 1) {
				String res = "";
				if (i == words.length) {
					blank = L - count - mid.size() + 1;
					num = mid.size() - 1;
					for (int j = 0; j < num; ++j) {
						res += mid.poll() + " ";
					}
					res += mid.poll();
					for (int j = 0; j < blank; ++j) {
						res += " ";
					}
				} else {
					blank = L - count;
					num = mid.size() - 1;
					mod = blank % num;
					blank = blank / num;
					for (int j = 0; j < num; ++j) {
						res += mid.poll();
						for (int n = 0; n < blank; ++n) {
							res += " ";
						}
						if (j < mod) {
							res += " ";
						}
					}
					res += mid.poll();
				}
				result.add(res);
				count = 0;
				--i;
			} else if (mid.size() == 1) {
				String res = "";
				blank = L - count;
				res += mid.poll();
				for (int n = 0; n < blank; ++n) {
					res += " ";
				}
				result.add(res);
				count = 0;
				--i;
			}

		}
		return result;
	}

	public boolean isNumber(String s) {
		try {
			char c = s.charAt(s.length() - 1);
			if (c == 'f' || c == 'F' || c == 'd' || c == 'D')
				return false;
			Double d = Double.valueOf(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @author yukunlee
	 * @Description addBinary
	 * @date 2018年12月4日
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
		int alen = a.length() - 1, blen = b.length() - 1, f = 0;
		String res = "";
		while (alen >= 0 || blen >= 0 || f != 0) {
			int sum = alen >= 0 ? a.charAt(alen--) - '0' : 0;
			sum += blen >= 0 ? b.charAt(blen--) - '0' : 0;
			sum += f;
			res = (char)(sum % 2 + '0') + res;
			f = sum >> 1;
		}
		return res;
	}
	
    /**
     * @author yukunlee
     * @Description TODO
     * @date 2018年12月4日
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> mp = new HashMap<>();
    	int[] res = new int[2];
    	for(int i = 0 ; i < nums.length ; ++i) {
    		if(mp.containsKey(target - nums[i])){
    			res[0] = mp.get(target - nums[i]);
    			res[1] = i;
    			return res;
    		}
    		if(!mp.containsKey(nums[i])) {
    			mp.put(nums[i], i);
    		}
    	}
        return null;
    }
    
    
    /**
     * @author yukunlee
     * @Description mergeTwoLists
     * @date 2018年12月5日
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);
        ListNode cur = prehead;
        while(l1 != null && l2 != null) {
        	if(l1.val <= l2.val) {
        		cur.next = l1;
        		l1 = l1.next;
        		cur = cur.next;
        		if(l1 == null) {
        			cur.next = l2;
        			return prehead.next;
        		}
        	}else {
        		cur.next = l2;
        		l2 = l2.next;
        		cur = cur.next;
        		if(l2 == null) {
        			cur.next = l1;
        			return prehead.next;
        		}
        	}
        	
        }
        return l1 == null? l2:l1;
    } 
    
    
}
