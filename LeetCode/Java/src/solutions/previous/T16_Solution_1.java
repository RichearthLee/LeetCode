package solutions.previous;

import java.util.HashMap;
import java.util.Map;

public class T16_Solution_1 {
	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年11月7日
	 * @param points
	 * @return
	 */
	public int maxPoints_1(Point[] points) {
		int n = points.length;
		int max = 0;

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;		
		}
		
		for(int i = 0 ;i < n ; i++) {
			int dup = 1;
			int vlt = 0;
			Map<Float, Integer> map = new HashMap<>();
			Point a = points[i];
			for(int j = 0 ; j < n ; j++) {
				if(i == j) continue; 
				Point b = points[j];
				if(a.x == b.x) {
					if(a.y == b.y) dup++;
					else vlt++;
				}
				else {
					float k = (float)(a.y - b.y) / (a.x - b.x);
					if(map.get(k) == null) map.put(k, 1);
					else map.put(k, map.get(k)+1);
				}
				
				int m = vlt;
				for(float k : map.keySet()) {
					m = Math.max(m, map.get(k));
				}
				max = Math.max(max, m + dup);
			}			
		}
		
		return max;	
	}
}
