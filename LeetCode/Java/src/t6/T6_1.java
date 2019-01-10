package t6;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class T6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int h=0;
		int d=0;
		int b=0;
		boolean a=false;
		List<Integer> arr=new ArrayList<Integer>();
		for(int i=m;i<=n;i++) {
			h=i/100;
			d=(i-h*100)/10;
			b=i-h*100-d*10;
			if(i==(Math.pow(h, 3)+Math.pow(d, 3)+Math.pow(b, 3))) {
				arr.add(i);
				a=true;
			}			
		}
		if(!a) {
			System.out.print("no");
		}
		else {
			for(int i=0;i<arr.size();i++) {
				if(i==arr.size()-1) {
					System.out.print(arr.get(i));
				}
				else {
					System.out.print(arr.get(i)+" ");
				}				
			}
		}
	}
}
