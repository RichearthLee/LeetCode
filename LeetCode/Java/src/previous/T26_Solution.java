package previous;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月6日
 */
public class T26_Solution {
		/**
		 * @author yukunlee
		 * @Description Given an array of integers, every element appears three times except for one. 
		 * Find that single one.
		 * @date 2018年10月6日
		 * @param A
		 * @return
		 */
		public int singleNumber2(int[] A) {
		        int ones = 0;//记录只出现过1次的bits
		        int twos = 0;//记录只出现过2次的bits
		        int threes;
		        for(int i = 0; i < A.length; i++){
		            int t = A[i];
		            twos |= ones&t;//要在更新ones前面更新twos
		            ones ^= t;
		            threes = ones&twos;//ones和twos中都为1即出现了3次
		            ones &= ~threes;//抹去出现了3次的bits
		            twos &= ~threes;
		        }
		        return ones; 
		    }
		/**
		 * @author yukunlee
		 * @Description Given an array of integers, every element appears twice except for one. 
		 * Find that single one.
		 * @date 2018年10月6日
		 * @param A
		 * @return
		 */
		public  int singleNumber(int[] A) {
		    int num = 0;
		    for(int i=0;i<A.length;i++){
		        num^=A[i];
		    }
		    return num;
		}
}
