package solutions.previous;

public class T1_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ShortestPath s = new ShortestPath();
//		double v1 = Double.POSITIVE_INFINITY;
//		double v2 = Double.MAX_VALUE;
//		System.out.println(v1 > v2 ? 1 : 2);
		matrix(4);
		

	}
	
	public static void matrix(int n) {
		int[][] mtx = new int[n][n];
		int a = 0;
		int b = n - 1;
		for (int i = 1; i <= n * n; ++i) {
			mtx[a][b] = i;
			System.out.print(a + " ");
			System.out.println(b);
			if ((b == n - 1 || mtx[a][b+1] != 0) && (a < n-1 && mtx[a+1][b] == 0)) {
				++a;
				continue;
			} else if ((a == n - 1 || mtx[a+1][b] != 0) && (b > 0 && mtx[a][b-1] == 0)) {
				--b;
				continue;
			} else if ((b == 0 || mtx[a][b-1] != 0) && (a > 0 && mtx[a-1][b] == 0)) {
				--a;
				continue;
			} else if ((a == 0 || mtx[a-1][b] != 0) && (b < n-1 && mtx[a][b+1] == 0)) {
				++b;
				continue;
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(mtx[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
