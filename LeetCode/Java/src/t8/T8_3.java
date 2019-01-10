package t8;

import java.util.Scanner;

public class T8_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuffer sb=new StringBuffer();
		sb.append(sc.next());
		int cut=sc.nextInt();
		long st=System.currentTimeMillis();
		int c=0;

		for(int i=0;i<cut;i++) {
			c=0;
			for(int j=1;j<sb.length();j++) {
				if(sb.charAt(j-1)<sb.charAt(j)) {
					break;
				}
                else{
                    c++;
                }
			}
			sb.deleteCharAt(c);
		}
		
		System.out.println(sb.toString());
		long ed=System.currentTimeMillis();
		System.out.println(ed-st);

	}
}
