package solutions.previous;

import java.util.Scanner;

public class T8_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		long cut=sc.nextInt();
		
		String str=s;	
		
		String[] arr =new String[50001];
		int[] n=new int[50001];
		int length=str.length();
		
		for(int i=0;i<str.length();i++) {
			arr[i]=str.substring(i, i+1);
			//System.out.print(arr[i]);
		}
/*		for(String i:arr) {
			n[i]=Integer.valueOf(arr[i]);
		}
*/
		for(int i=0;i<length;i++) {
			n[i]=Integer.valueOf(arr[i]);
			//System.out.print(n[i]);
		}
		
		for(int i=0;i<length;i++) {
			if(true) {
				//System.out.print(n[i]);
			}
		}

		for(int i=0;i<cut;i++) {
			cutNum(n,length);
		}
		System.out.println();
		for(int i=0;i<length;i++) {
			if(n[i]>=0) {
				System.out.print(n[i]);
			}
		}
		

	}
	
	public static void  cutNum(int[] n1,int length){		
		int[] min=new int[length];
		min[0]=n1[0];
		for(int i=0;i<length;i++) {
			if(n1[i]<min[0]&&n1[i]>=0) {
				min[0]=n1[i];
				min[1]=i;
			}
		}
		n1[min[1]]=-1;
}

}
