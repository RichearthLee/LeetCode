package t1;

import java.util.Scanner;

public class T4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] depth=new int[n];
		int[] binary=new int[n];
		depth[0]=1;
		int max=0;
		for(int i=0;i<n-1;i++) {
			int parent=sc.nextInt();
			int child=sc.nextInt();
			binary[parent]+=1;
			if(binary[parent]<3) {
				depth[child]=depth[parent]+1;
			}
			max=Math.max(max, depth[child]);
		}
		System.out.println(max);	
	}
}
