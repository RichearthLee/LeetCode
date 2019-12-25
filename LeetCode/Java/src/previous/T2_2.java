package previous;

import java.util.Arrays;
import java.util.Scanner;

public class T2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr=new String[n];
        for (int i=0;i<n;i++){
        	arr[i]=String.valueOf(sc.nextInt());//integer.toString(i)
        }
        
       Arrays.sort(arr);
       
/*       for(String str:arr) {
    	   System.out.println(str);
       }
*/
       for(int i=arr.length-1;i>=0;i--) {
    	   System.out.print(arr[i]);  	   
       }
       
	}

}
