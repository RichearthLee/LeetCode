package t3;

import java.util.Scanner;

public class T3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String[] arr;
		while(sc.hasNextLine()) {
			arr=sc.nextLine().split(" ");
			//if(sc.nextLine().equals(""));break;
			for (int i=arr.length-1;i>=0;i--) {
				if(i==0) {
					System.out.print(arr[i]);
				}
				else {
					System.out.print(arr[i]+" ");
				}
				
			}
		}
		sc.close();

	}

}
