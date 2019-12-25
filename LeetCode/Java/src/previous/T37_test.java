package previous;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T37_test {

	static int find_cheapest_path(int n, int m, int[][] flights) {
		int res = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		int len = flights.length;
		while (!q.isEmpty()) {
			// int start = q.remove();
			int start = q.poll();
			for (int i = 0; i < len; ++i) {
				if (flights[i][0] == start) {
					q.offer(flights[i][1]);
				}
			}
		}
		return res;
	}

	static int cheapest(int plane, LinkedList<Integer> city, int sum, int[][] flights) {
		int len = flights.length;
		int min = Integer.MAX_VALUE;
		if (city.peek() == 1) {
			return 0;
		}
		for (int i = 0; i < len; ++i) {
			if (flights[i][0] == city.peek() && !city.contains(flights[i][0])) {
				city.add(flights[i][1]);
				if (plane == flights[i][2]) {
					sum = Math.round(flights[i][3] * 7 / 10) + cheapest(plane, city, sum, flights);
					min = Math.max(min, sum);
				} else {
					plane = flights[i][2];
					sum = flights[i][3] + cheapest(plane, city, sum, flights);
					min = Math.max(min, sum);
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _n;
		_n = Integer.parseInt(in.nextLine().trim());

		int _m;
		_m = Integer.parseInt(in.nextLine().trim());

		int _flights_rows = 0;
		int _flights_cols = 0;
		_flights_rows = Integer.parseInt(in.nextLine().trim());
		_flights_cols = Integer.parseInt(in.nextLine().trim());

		int[][] _flights = new int[_flights_rows][_flights_cols];
		for (int _flights_i = 0; _flights_i < _flights_rows; _flights_i++) {
			for (int _flights_j = 0; _flights_j < _flights_cols; _flights_j++) {
				_flights[_flights_i][_flights_j] = in.nextInt();

			}
		}

		if (in.hasNextLine()) {
			in.nextLine();
		}

		//ArrayList<Integer> arr = new ArrayList<>();
		LinkedList<Integer> lin = new LinkedList<>();
		lin.add(0);


		// res = find_cheapest_path(_n, _m, _flights);
		res = cheapest(_n, lin, 0, _flights);
		System.out.println(String.valueOf(res));

	}

}
