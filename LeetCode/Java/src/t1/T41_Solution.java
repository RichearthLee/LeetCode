package t1;

public class T41_Solution {
    /**
     * @author yukunlee
     * @Description distinct-subsequences
     * @date 2018年10月31日
     * @param S
     * @param T
     * @return
     */
    public int numDistinct(String S, String T) {
        int row = T.length();
        int col = S.length();
        if(row > col) return 0;
        int [][] dp = new int[row+1][col+1];
        
        for(int i = 0 ;i <= col ; ++i) {
        	if(i < row) {
        		dp[i][0] = 0;
        	}
        	dp[0][i] = 1;
        }
      
        for(int i = 1 ; i <=row ;++i) {
        	for(int j = 1 ; j <= col ; ++j) {
        		if(T.charAt(i-1) == S.charAt(j-1)) {
        			dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
        		}else {
        			dp[i][j] = dp[i][j-1];
        		}
        	}
        }
    	return dp[row][col];
    }

}
