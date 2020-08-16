package solutions.previous;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T9_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		List<String> arr = new ArrayList<String >();
		String str = "";
		while(sc.hasNextLine()) {
			str = sc.nextLine();
			String[] as =str.split(" ");
			for(int i = 0 ; i<as.length ; i++) {
				if(as[i] == "") {
					break;
				}
				if(!arr.contains(as[i])) {
					arr.add(as[i]);
				}			
			}			
			//System.out.println(length);
		}
		System.out.println(arr.size());
	}
}
