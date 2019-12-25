package previous;

import java.util.ArrayList;

public class T38_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		ArrayList<Integer> arr3 = new ArrayList<>();
		arr2.add(1);
		arr1.add(arr2);
		
		//arr2.add(2);arr2.add(3);
		//arr1.add(arr2);
		
		arr3.add(2);arr3.add(3);
		arr1.add(arr3);
		T38_Solution t = new T38_Solution();
		System.out.println(t.minimumTotal_1(arr1));

	}

}
