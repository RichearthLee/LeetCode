#include "pch.h"
#include "Solution.h"

using namespace std;

Solution::Solution()
{
}


Solution::~Solution()
{
}

int Solution::minPathSum(vector<vector<int>>& grid)
{
	int row = grid.size(), col = grid[0].size();
	//int grid[row][col];//表达式必须含有常量值

	/*
	int row = grid.size()+1, col = grid[0].size()+1;
	int dp_1[row][col];//表达式必须含有常量值
	int **dp = new int[row][col]; //表达式必须含有常量值
	*/

	//向量初始化
	/*
	    vector<vector<int>> dp;
	    vector<vector<int>> newOne(r, vector<int>(c, 0));

	    vector<vector<int>> res;
        res.resize(r);//r行
        for (int k = 0; k < r; ++k){
            res[k].resize(c);//每行为c列
        }
	*/
	//int row = grid.size(), col = grid[0].size();
	//int dp[row][col];
	//grid[0][0] = grid[0][0];
	for(int i = 1 ; i < col ; ++i){
		grid[0][i] += grid[0][i - 1];
	}
	for (int i = 1; i < row; ++i) {
		grid[i][0] += grid[i-1][0];
	}

	for (int i = 1; i < row; ++i) {
		for (int j = 1; j < col; ++j) {
			grid[i][j] += min(grid[i - 1][j], grid[i][j - 1]);
		}
	}

	return grid[row-1][col-1];
}

int Solution::uniquePaths(int m, int n)
{
	vector<vector<int>> dp(m, vector<int>(n, 1));

	for (int i = 1; i < m; ++i) {
		for (int j = 1; j < n ; ++j) {
			dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		}
	}

	return dp[m-1][n-1];
}

int Solution::uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid)
{
	int row = obstacleGrid.size(), col = obstacleGrid[0].size();
	vector<vector<int>> dp(row, vector<int>(col, 0));
	if (obstacleGrid[0][0] == 1) {
		return 0;
	}
	else
	{
		dp[0][0] = 1;
	}
	for (int i = 1; i < col; ++i) {
		if (obstacleGrid[0][i] != 1)
		{
			dp[0][i] = 1;
		}
		else {
			break;
		}
	}
	for (int i = 1; i < row; ++i) {
		if (obstacleGrid[i][0] != 1)
		{
			dp[i][0] = 1;
		}
		else {
			break;
		}
	}
	for (int i = 1; i < row; ++i) {
		for (int j = 1; j < col ;++j)
		{
			dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
		}
	}
	return dp[row-1][col-1];
}

ListNode * Solution::rotateRight(ListNode * head, int k)
{
	if (k == 0 || head == nullptr) {
		return head;
	}

	ListNode *post = head;
	int len = 1;

	while (post->next)
	{
		++len;
		post = post->next;
	}

	k = len - k % len;

	post->next = head;
	for (int i = 0; i < k; ++i)
	{
		post = post->next;
	}
	head = post->next;
	post->next = nullptr;

	return head;
}
