package t30;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

import net.sf.json.JSONArray;  

public class T30_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T30_Solution sol = new T30_Solution();
		long start = System.nanoTime();
		//long start = System.currentTimeMillis();
		boolean b = sol.isPalindrome1(
				"");
		System.out.println(b);
		long end = System.nanoTime();
		//long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		System.out.println(list.remove("a"));
		
		String s = "abba";
		ArrayList<ArrayList<String>> result = sol.partition(s);
	/*	for(ArrayList<String> a : result) {
			for(String str : a) {
				System.out.print(str+",");
			}
			System.out.print("|");
		}*/
		JSONArray js = JSONArray.fromObject(result);
		System.out.println(js.toString());
		
		Vector<String> v = new Vector<>();
		Stack<String> st = new Stack<>();
		
		

	}

}
