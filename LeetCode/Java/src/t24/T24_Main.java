package t24;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class T24_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaaaa";
		Set<String> set = new HashSet<>();
		set.add("aaaa");
		set.add("aaa");
		T24_Solution sol = new T24_Solution();
		if(sol.wordBreakRecursion(s, 0, set , false)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}

}
