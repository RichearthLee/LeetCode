class Solution(object):

    num = 0
    #构造函数
    def __init__(self):
        self.num = 1


    def minPathSum(self, grid):
        n = len(grid)
        m = len(grid[0])
        dp = [[0] * m for i in range(n)]
        for i in range(n):
            for j in range(m):
                if i == 0 and j == 0:
                    dp[i][j] = grid[i][j]
                elif i == 0 and j != 0:
                    dp[i][j] = dp[i][j - 1] + grid[i][j]
                elif i != 0 and j == 0:
                    dp[i][j] = dp[i - 1][j] + grid[i][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        return dp[-1][-1]


# s = Solution()
# grid = [[0] * 4 for i in range(4)]
# s.minPathSum(grid)