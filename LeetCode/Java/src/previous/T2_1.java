package previous;

import java.util.Scanner;

public class T2_1 {

	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年11月8日
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr=new int[n][2];
        int a=0;
        for (int i=0;i<n;i++){
        	a=sc.nextInt();
            arr[i][0]=a;
            while(a>9) {
            	a=a/10;
            }
            arr[i][1]=a;
        }
        System.out.println(arr[0][0]+"----"+arr[0][1]);
        int[][] max=new int[1][2];
        for(int i=0;i<arr.length;i++) {
        	for(int j=i+1;j<arr.length;j++) {
        		if(arr[j][1]>arr[i][1]) {
        			max[0]=arr[i];
        			arr[i]=arr[j];
        			arr[j]=max[0];
        		}
        	}
        }
        
       for (int i=0;i<arr.length;i++) {
    	   System.out.println(arr[i][0]+"---"+arr[i][1]);
       }

	}

}
