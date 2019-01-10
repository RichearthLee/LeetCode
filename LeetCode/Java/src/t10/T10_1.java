package t10;

import java.util.Scanner;

/*
 * 牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，
 * 藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t，根据古老的传说
  牛牛需要每次都回答 t 是否是 s 的子序列。注意，子序列不要求在原字符串中是连续的，
 例  如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
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
