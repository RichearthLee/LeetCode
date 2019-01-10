package t16;

public class T16_Solution {
	public int maxPoints(Point[] points) {
		// BigDecimal k;
		// BigDecimal b;
		double k1;
		int b1;
		int vertical = 0;
		int maxNum = 0;
		if (points.length == 0) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int count = 0;
				if (points[i].x == points[j].x) {
					vertical = points[i].x;
					for (int n = 0; n < points.length; n++) {
						if (points[n].x == vertical) {
							count++;
						}
					}

				} else {
	/*				
					 * 
					 * BigDecimal a1 = new BigDecimal(point[i].y); BigDecimal a2 = new
					 * BigDecimal(point[i].x); BigDecimal b1 = new BigDecimal(point[j].y);
					 * BigDecimal b2 = new BigDecimal(point[j].x);
					 * 
					 * k = (a1.subtract(b1)).divide(a2.subtract(b2)).setScale(20,
					 * java.math.BigDecimal.ROUND_HALF_UP); b = a1.subtract(k.multiply(a2));
					 * 
					 * for (int n = 0; n < point.length; n++) { BigDecimal c1 = new
					 * BigDecimal(point[n].y); BigDecimal c2 = new BigDecimal(point[n].x); if
					 * (c1.equals(c2.multiply(k).add(b).setScale(0,
					 * java.math.BigDecimal.ROUND_HALF_UP)) ) { count++; } }
					 
*/
					
					  k1 = (points[i].y - points[j].y) / (points[i].x - points[j].x); 
					  b1 = (int)(points[i].y - k1 * points[i].x);
					  
					  for (int n = 0; n < points.length; n++) { 
						  if (Math.round(points[n].y) ==Math.round((int)(points[n].x *k1) + b1) ) { 
						  count++;
						  }
					  }
					 
					
					/*
					for (int n = 0; n < point.length; n++) {
						if (point[n].y == (int) (point[n].x * (point[i].y - point[j].y) / (point[i].x - point[j].x))
								+ (int)(point[i].y - (point[i].y - point[j].y) / (point[i].x - point[j].x) * point[i].x)) {
							count++;
						}
					}
					*/
				}
				maxNum = Math.max(maxNum, count);
			}
		}
		return maxNum;
	}
}
