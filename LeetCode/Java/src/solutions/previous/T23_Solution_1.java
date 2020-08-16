package solutions.previous;

import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年9月28日
 */
public class T23_Solution_1 {
	public ArrayList<String> wordBreak(String s , Set<String> dict){
		ArrayList<String> str = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		
		if(s==null||s.isEmpty()||dict.isEmpty()) {
			return result;
		}
		
		String sub = "";

		int index = 0;
		str = recursion(s, index,dict, str);
		for(int i = 0 ; i < str.size() ; ++i) {
			sub = sub + str.get(i) + " ";
			if(!s.startsWith(sub.replaceAll(" ", ""))) {
				sub = "";
				i--;
			}
			if(s.equals(sub.replaceAll(" ", ""))) {
				result.add(sub);
				sub.substring(0,sub.length()-1);
				sub = "";
			}
		}
		return result;
	}

	private ArrayList<String> recursion(String s , int index , Set<String> dict , ArrayList<String> str){
		Stack<String> st = isContains(s, dict , index);
		while(!st.empty()) {
				str.add(st.peek());
				index = s.indexOf(st.peek())+st.pop().length();
				recursion(s, index,dict, str);
		}
		return str;
	}
	private Stack<String> isContains(String s ,Set<String> dict , int index ) {
		Stack<String> st = new Stack<>();
		for(String str : dict) {
			if(s.startsWith(str , index)) {
				st.push(str);
			}
		}
		return st;
	}
}
