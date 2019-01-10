package t28;

public class T28_Solution {
	/**
	 * @author yukunlee
	 * @Description Return the starting gas station's index if you can travel around
	 *              the circuit once, otherwise return -1
	 * @date 2018年10月7日
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int end = gas.length - 1;
		int count = 0;
		count = gas[end] - cost[end];
		while (end > start) {
			if (count >= 0) {
				count += gas[start] - cost[start];
				++start;
			} else {
				count += gas[end] - cost[end];
				--end;
			}
		}
		return count >= 0 ? end : -1;
	}
}
