package t16;

public class T16 {
/*
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T16_Solution t16 = new T16_Solution();
		Point[] p = new Point[4];
		p[0] = new Point(3,10);
		p[1] = new Point(0,2);
		p[2] = new Point(0,2);
		p[3] = new Point(3,10);
		System.out.println(t16.maxPoints(p));

	}

}
