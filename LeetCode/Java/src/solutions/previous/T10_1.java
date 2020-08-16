package solutions.previous;

import java.util.Scanner;

/*
 * ţţ�õ���һ���ر�ͼ��˳�Ųر�ͼ��ָʾ��ţţ������һ���ر��У�
 * �ر�������һ�����أ�����ÿ�λ���ʾ�����ַ��� s �� t�����ݹ��ϵĴ�˵
  ţţ��Ҫÿ�ζ��ش� t �Ƿ��� s �������С�ע�⣬�����в�Ҫ����ԭ�ַ������������ģ�
 ��  �紮 abc�����������о��� {�մ�, a, b, c, ab, ac, bc, abc} 8 �֡�
 */

public class T10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();	
		boolean f = true;
		int len = s2.length();
		
		for (int i = 0 ; i < len ; i++) {
			if(s1.indexOf(s2.substring(0, 1)) != -1) {
				s1 = s1.substring(s1.indexOf(s2.substring(0, 1))+1);
				s2 = s2.substring(1);
				//System.out.println(s2);
				//System.out.println(s1);
			}
			else {
				f = false;
			}
		}
		if(f) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}

	}

}
