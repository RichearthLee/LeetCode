package t27;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月7日
 */
public class T27_Solution {
	/**
	 * @author yukunlee
	 * @Description There are N children standing in a line. Each child is assigned
	 *              a rating value. You are giving candies to these children
	 *              subjected to the following requirements: Each child must have at
	 *              least one candy. Children with a higher rating get more candies
	 *              than their neighbors. What is the minimum candies you must give?
	 * @date 2018年10月7日
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {

		int len = ratings.length;
		int min = len;
		int lastmin = 0;
		int[] candy = new int[len];
		Arrays.fill(candy, 1);
		if (len == 0) {
			return 0;
		}
		for (int j = 0; j < len; ++j) {
			if (lastmin == min && min != 0) {
				break;
			}
			lastmin = min;
			for (int i = 0; i < len; ++i) {
				if (ratings[i] > ratings[(i == 0 ? i : i - 1)] && candy[i] <= candy[(i == 0 ? i : i - 1)]) {
					++candy[i];
					++min;
				}
				if (ratings[i] > ratings[(i == len - 1 ? i : i + 1)] && candy[i] <= candy[i == len - 1 ? i : i + 1]) {
					++candy[i];
					++min;
				}
			}
		}
		return min;
	}

	/**
	 * @author yukunlee
	 * @Description TODO
	 * @date 2018年10月7日
	 * @param ratings
	 * @return
	 */
	public int candy_1(int[] ratings) {
		Vector<Integer> candy = new Vector<>();

		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int[] count = new int[ratings.length];
		Arrays.fill(count, 1);
		int sum = 0;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				count[i] = count[i - 1] + 1;
			}
		}

		for (int i = ratings.length - 1; i > 0; i--) {
			sum += count[i];
			if (ratings[i] < ratings[i - 1] && count[i] >= count[i - 1]) {
				count[i - 1] = count[i] + 1;
			}
		}
		sum += count[0];

		return sum;

	}
}
