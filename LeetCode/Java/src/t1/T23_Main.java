package t1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class T23_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();
		ArrayList<String> ret = new ArrayList<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		String s1 = "abc";
		Set<String> dict1 = new TreeSet<>();
		
		T23_Solution sol = new T23_Solution();
		ret = sol.wordBreak(s, dict);
//		T23_Solution_1 Solution1 = new T23_Solution_1();
//		ret = Solution1.wordBreak(s, dict);
		
		for(String str : ret) {
			System.out.println(str);
		}
	}

}
