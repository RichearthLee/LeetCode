package solutions.previous;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yukunlee
 * @Description word-ladder BFS
 * @date 2018年10月24日
 */
public class T34_Solution {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		Queue<String> queue = new LinkedList<>();
		int result = 1;
		queue.offer(start);
		while (!queue.isEmpty()) {
			int layer = queue.size();
			while (layer > 0) {
				String str = queue.poll();
				--layer;
				if (str.equals(end))
					return result;
				for (Iterator<String> it = dict.iterator(); it.hasNext();) {
					String s1 = it.next();
					if (isOneDiffer(s1, str)) {
						queue.offer(s1);
						it.remove();
					}
				}
			}
			++result;
		}
		return 0;
	}
	/*
	 * int layer = queue.size(); while (layer > 0) { String str = queue.poll(); if
	 * (str.equals(end)) return result; for (Iterator<String> it = dict.iterator();
	 * it.hasNext();) { String s1 = it.next(); if (isOneDiffer(s1, str)) {
	 * queue.offer(s1); it.remove(); } } } ++result;
	 */

	private boolean isOneDiffer(String s1, String s2) {
		int len = s1.length();
		if (len < 1)
			return false;
		int count = len;
		for (int i = 0; i < len; ++i) {
			if (s1.charAt(i) == s2.charAt(i)) {
				--count;
			}
		}
		return count == 1 ? true : false;
	}
}
