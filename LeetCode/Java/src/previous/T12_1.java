package previous;

import java.util.Scanner;

/*
 * С��ȥ�������̵���ƻ������թ���̷�ʹ���������ף�ֻ�ṩ6��ÿ����8��ÿ���İ�װ(��װ���ɲ��)��
 *  ����С������ֻ�빺��ǡ��n��ƻ����С���빺�����ٵĴ�������Я����������ܹ���ǡ��n��ƻ����
 *  С�׽����Ṻ��
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
