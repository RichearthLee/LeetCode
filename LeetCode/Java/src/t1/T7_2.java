package t1;

public class T7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="12345";
		System.out.println(str.length());
		StringBuffer sb=new StringBuffer(str);
		System.out.println(sb.substring(0, 3).toString());
		
		int a=0;
		for(int i=0;i<10;i++) {
			
			for(int j=0;j<10;j++) {
				a++;
				if(a<4)break;
			}
			
		}
		System.out.println(a);

	}

}
