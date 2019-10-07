package t1;

import java.util.ArrayList;

public class T39_Solution {
	/**
	 * @author yukunlee
	 * @Description pascals-triangle
	 * @date 2018年10月30日
	 * @param numRows
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> li = new ArrayList<>();
		int l1;
		int l2;
		li.add(new ArrayList<>());
		if(numRows <1) {
			return li;
		}
		li.get(0).add(1);
		for (int i = 1; i < numRows; ++i) {
			int len = li.get(i - 1).size();
			li.add(new ArrayList<>());
			for (int j = 0; j <= len; ++j) {
				l1 = j - 1 < 0 ? 0 : li.get(i - 1).get(j - 1);
				l2 = j > len - 1 ? 0 : li.get(i - 1).get(j);
				li.get(i).add(l1+l2);
			}
		}
		return li;
	}

	/**
	 * @author yukunlee
	 * @Description pascals-triangle-ii
	 * @date 2018年10月30日
	 * @param numRows
	 * @return
	 */
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> li = new ArrayList<>();
        if(rowIndex < 0 ) {
        	return li;
        }
        li.add(1);
		int l1, l2;
        for(int i = 1 ; i <= rowIndex ; ++i) {
        	int len = li.size();
        	l2 = 1;
        	for(int j = 1 ; j < len ; ++j) {
        		l1 = li.get(j);
        		li.set(j, l2+li.get(j));
        		l2 = l1;
        	}
        	li.add(1);
        }
    	return li;
    }
    
}
