package test;

import java.util.*;

public class TestMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		System.out.println(Find(16,arr));
		TestMethod tm = new TestMethod();
		tm.testIntArray();
         
	}
	 public static boolean Find(int target, int [][] array) {
	        int rowCount=array.length;
	        int colCount=array[0].length;
	        int i=0,j=colCount-1;
	        boolean f=false;
	        while(i<rowCount&&j>=0){
	        	if(target==array[i][j]){
	                f=true;
	                break;               
	            }
	            if(target>array[i][j]){
	                i++;
	                continue;
	            }
	            if(target<array[i][j]){
	                j--;
	                continue;
	            }
	            
	        }
	       return f;
	}

	public void testParam(List<String> list, int n, String str){
		list.add("test");
		n = n+1;
		str = str + "test";
	}


	public void testChar2Int(){
		String str = "123";
		System.out.println(str.charAt(0)-'0');
		System.out.println(Character.getNumericValue(str.charAt(0)));
	}


	public  void testInsertArray(){
		System.out.println("------");
		ArrayList<Integer> ts = new ArrayList<>();
		for(int i = 0 ; i < 10 ; ++i){
			ts.add(i);
		}
		for(int i = 0 ; i < ts.size() ; ++i){
			if(i == 5){
				ts.add(i,100);
			}
		}
		for(int i = 0 ; i < ts.size() ; ++i){
			System.out.println(ts.get(i));
		}
	}

	public void testDate(){
		System.out.println(new Date());
	}


	public void testHashMap() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("M", 1000);
		map.put("D", 500);
		map.put("C", 100);
		map.put("L", 50);
		map.put("X", 10);
		map.put("V", 5);
		map.put("I", 1);
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("M", 1000);
//        map.put("D", 500);
//        map.put("C", 100);
//        String[] match = {"M", "D", "C", "L", "X" ,"V" ,"I"};
//        StringBuffer sb= new StringBuffer(s);

	}


	public void testForeach() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; ++i) {
			list.add(i);
		}

//        for(Integer i : list){
//            System.out.println(i);
//            list.remove(i);
//        }
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i));
			list.remove(i);
			--i;
		}
	}

	public void testArrayList() {
		ArrayList arr1;
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(1);
		if (1 < 2) {
			arr1 = arr2;
		}
		System.out.println(arr1.get(0));
	}

	public void testMap(){
		Map<String, Integer> map = new HashMap<>();
		System.out.println(map.get("a"));
	}

	public void testLinkedList(){
		LinkedList<String> ll = new LinkedList<>();
		ll.add(null);
		ll.add(null);
		System.out.println(ll.size());
	}

	public void testClass(){
		Map<String, String> map1 = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();

		Set<String> set1 = new HashSet<>();

		System.out.println(map1.getClass().equals(set1.getClass()));
	}

	public void testIntArray(){
		int[][] res = new int[2][];
		int[] a = new int[1];
		res[0] = a;
		System.out.println(res[0][0]);

		int[][] t1 = new int[0][0];
		System.out.println(t1.toString());
		t1[0][0] = 1;
		System.out.println(t1[0][0]);
	}

}
