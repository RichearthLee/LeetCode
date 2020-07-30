package solutions.previous;

import java.util.HashSet;

public class T34_test {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("hot");
		set.add("dog");
		set.add("dot");
		T34_Solution t = new T34_Solution();
		System.out.println(t.ladderLength("hot", "dog", set));

	}

}
