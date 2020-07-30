package solutions.previous;

import java.util.HashSet;
import java.util.Set;

public class T33_Solution {
	public int longestConsecutive(int[] num) {
		Set<Integer> s = new HashSet<>();
		for(int o : num) {
			s.add(o);
		}
		int longest = 1;
		for(int o : num) {
			if(s.remove(o)) {
				int sum = 0 ;
				int pre = o-1;
				int post = o+1;
				while(s.remove(pre)) {
					--pre;
					++sum;
				}
				while(s.remove(post)) {
					++post;
					++sum;
				}
				longest = Math.max(longest, sum);
			}
		}
		return longest;
	}
}
