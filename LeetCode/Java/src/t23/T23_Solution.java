package t23;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年9月28日
 */
public class T23_Solution {
	public ArrayList<String> wordBreak(String s , Set<String> dict){
		ArrayList<String> str = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		
		if(s==null||s.isEmpty()||dict.isEmpty()) {
			return result;
		}
		
		String sub = "";

		int index = 0;
		str = recursion(s, index, dict, str);
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
		for(int i = index+1 ; i <= s.length() ; ++i) {
			if(dict.contains(s.substring(index, i))){
				str.add(s.substring(index, i));
				recursion(s, i, dict, str);
				continue;
			}
		}
		return str;
	}
}
