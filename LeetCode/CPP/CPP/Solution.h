#pragma once
#include "pch.h"

using namespace std;


class Solution
{
public:
	Solution();
	virtual ~Solution();
	int minPathSum(vector<vector<int> > &grid);
	int uniquePaths(int m, int n);
	int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid);
	ListNode *rotateRight(ListNode *head, int k);
};

