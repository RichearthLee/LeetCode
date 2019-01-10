package t1;

import java.util.Arrays;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月11日
 */
public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("i love you");
		System.out.println(replaceSpace(sb));
		

	}
	
    public static String replaceSpace(StringBuffer str) {
	String[] s=str.toString().split(" ");
	StringBuffer sb1=new StringBuffer();
	for(int i=0;i<s.length;i++) {
		if(i==s.length-1) {
			sb1=sb1.append(s[i]);
		}else {
			sb1=sb1.append(s[i]+"%20");
		}		
	}
	return sb1.toString();	
    }

}
