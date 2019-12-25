package previous;

import java.text.DecimalFormat;
import java.util.Scanner;

public class T5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double m=sc.nextInt();
		double n=sc.nextInt();
		double[] arr=new double[(int) n];
		arr[0]=m;
		for(int i=0;i<n-1;i++) {
			arr[i+1]=Math.sqrt(arr[i]);
			m+=arr[i+1];
		}
		
/*		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		System.out.println(nf.format(m));
*/
		
		DecimalFormat df=new DecimalFormat("#.00");
		System.out.println(df.format(m));
/*	
		BigDecimal bd=new BigDecimal(n);
		double d=bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(d);
*/

	}

}
