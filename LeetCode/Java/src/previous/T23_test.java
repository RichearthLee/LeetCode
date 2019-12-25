package previous;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class T23_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcde";
		String str1 = "ab";
		
		str = str.substring(str.indexOf(str1));
		System.out.println(str);
		
		
		Stack<String> st = new  Stack<>();
		Stack<String> st1 = null;
		if(st.empty()) {
			System.out.println("empty");
		}
		if(st.isEmpty()) {
			System.out.println("is empty");
		}
//		if(st1.empty()) {
//			System.out.println("null");
//		}
		
		Set<String> set = new TreeSet<>();
		set = null;
		
		for(String str2 : set) {
			System.out.println(str);
		}

	}

}
