package solutions.previous;

import java.util.Scanner;

public class T7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuffer sb=new StringBuffer(sc.nextLine());
		String str="";
		boolean f=false;
		int a=sb.length();
		for(int i=5;i<sb.length();i++) {
			if(f) {
				break;
			}
			for(int j=0;j<sb.length()-1;j++) {
				if(i+j<=sb.length()) {
					str=sb.substring(j, j+i);
				}
				else {
					str=sb.substring(j, sb.length())+sb.substring(0, i+j-sb.length());
				}
				
				if(str.contains("A")&&str.contains("B")&&str.contains("C")&&str.contains("D")&&str.contains("E")) {
					f=true;					
					a=str.length();	
					break;
				}
				
			}
		}
		System.out.println(sb.toString());
		System.out.println(str);
		if(f) {
			System.out.println(sb.length()-a);
		}
		else {
			System.out.println(a);
		}

	}

}
