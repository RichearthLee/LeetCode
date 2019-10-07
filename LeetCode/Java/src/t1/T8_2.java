package t1;

import java.util.Scanner;

public class T8_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuffer sb=new StringBuffer();
		sb.append(sc.next());
		int cut=sc.nextInt();
		
		int c=0;
		int min=sb.charAt(0);

		for(int i=0;i<cut;i++) {
			for(int j=0;j<sb.length();j++) {
				if(min>sb.charAt(j)) {
					min=sb.charAt(j);
					c=j;
				}
			}
			sb.deleteCharAt(c);
		}
		
		System.out.println(sb.toString());

	}

}
