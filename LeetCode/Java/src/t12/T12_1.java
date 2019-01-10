package t12;

import java.util.Scanner;

/*
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
 *  可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，
 *  小易将不会购买。
 */
public class T12_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		boolean f = false;


		int m = n / 6;
		int j = 0;
		for (int i = 0; i <= m; i++) {
			j = (n - i * 6);
			if (j % 8 == 0) {
				System.out.println(j / 8 + i);
				f = true;
				break;
			}
		}

		if (!f) {
			System.out.println(-1);
		} 

	}

}
