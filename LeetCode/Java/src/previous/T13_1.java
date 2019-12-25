package previous;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T13_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
			// a.add(n, a.get(n)+a.get(i));
		}
		sc.close();
		a.add(0);
		for (int i = 0; i < n; i++) {
			a.add(n, a.get(n) + a.get(i));
		}

		boolean f = true;
		if (a.get(n) % n != 0) {
			System.out.println(-1);
		} else {
			int avg = a.get(n) / n;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if ((a.get(i) - avg) % 2 != 0) {
					f = false;
					break;
				} else {
					count = count + (Math.abs(a.get(i) - avg)) / 2;
				}
			}
			if (f) {
				System.out.println(count / 2);
			} else {
				System.out.println(-1);
			}
		}

	}

}
