package t1;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月11日
 */
public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("i love you");
		System.out.println(replaceSpace(sb));
	}
	
    public static String replaceSpace(StringBuffer str) {
	int a=0;
	while(str.indexOf(" ")!=-1) {
		a=str.indexOf(" ");
		str=str.replace(a, a+1, "%20");			
	}
	return str.toString();	
    }

}
