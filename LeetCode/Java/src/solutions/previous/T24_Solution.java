package solutions.previous;

import java.util.Set;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年9月29日
 */
/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年9月29日
 */
public class T24_Solution {
	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年9月29日
	 * @param s
	 * @param dict
	 * @return
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		int len = s.length();
		int head = 0;
		for(int i = 1 ; i <= len ; ++i) {
			if(dict.contains(s.substring(head, i))){
				head = i;
				if(i == len) {
					return true;
				}
				continue;
			}
		}
		return false;
	}
	/**
	 * @author yukunlee
	 * @Description dp
	 * @date 2018年9月30日
	 * @param s
	 * @param dict
	 * @return
	 */
	public boolean wordBreakDP(String s, Set<String> dict) {
		int len = s.length();
		boolean[] arr= new boolean[len + 1];
		arr[0] = true;
		for(int i = 1 ; i <= len ; ++i) {
			for(int j = 0 ; j < i ; ++j) {
				if(arr[j] && dict.contains(s.substring(j, i))) {
					arr[i] = true ;
					break;
				}
			}
		}
		return arr[len];
	}
	
	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年9月29日
	 * @param s
	 * @param index
	 * @param dict
	 * @param str
	 * @return
	 */
	public boolean wordBreakRecursion(String s , int index , Set<String> dict , boolean b){
	
		for(int i = index+1 ; i <= s.length() ; ++i) {
			if(b == true) {
				return b;
			}
			if(dict.contains(s.substring(index, i))){
				if(i == s.length()) {
					b = true;
					return b;
				}
				b=wordBreakRecursion(s, i, dict,b);
			}
		}
		return b;
	}
}
