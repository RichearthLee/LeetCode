# coding=utf-8
import numpy as np

from utility.data_structure import ListNode


class Solution(object):
    num = 0

    # 构造函数
    def __init__(self):
        self.num = 1

    def minPathsSum(self, grid):
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

    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)
        cur = head
        flag = 0
        while (l1 != None or l2 != None or flag == 1):
            if l1 == None and l2 == None:
                num = 0
            elif l2 == None:
                num = l1.val
                l1 = l1.next
            elif l1 == None:
                num = l2.val
                l2 = l2.next
            else:
                num = l1.val + l2.val
                l1 = l1.next
                l2 = l2.next
            node = ListNode(0)
            node.val = (num + flag) % 10
            flag = (num + flag) / 10
            cur.next = node
            cur = cur.next
        return head.next

    def addTwoNumbers_1(self, l1, l2):
        carry = 0
        root = n = ListNode(0)
        while l1 or l2 or carry:
            v1 = v2 = 0
            if l1:
                v1 = l1.val
                l1 = l1.next
            if l2:
                v2 = l2.val
                l2 = l2.next
            carry, val = divmod(v1 + v2 + carry, 10)
            n.next = ListNode(val)
            n = n.next
        return root.next

    @staticmethod
    def printMatrix(matrix):
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                print(matrix[i][j], end='\t')
            print()

    def longestPalindrome(self, str):
        length = len(str)
        if (length == 0 or length == 1):
            return str
        dp = np.zeros((length,length))
        res = ""
        for i in range(length):
            for j in range(i+1):
                if(str[i] == str[j] and ((i - j < 2) or dp[i-1][j+1]==1)):
                    dp[i][j]=1
                else:
                    dp[i][j]=0
                if (dp[i][j]==1 and (len(res)==0 or i-j+1>len(res))):
                    res = str[j:i+1]
        Solution.printMatrix(dp)
        return res

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        current = res = ListNode(0)
        while l1 and l2:
            if(l1.val < l2.val):
                current.next = l1
                current = l1
                l1 = l1.next
            else:
                current.next = l2
                current = l2
                l2 = l2.next
        # if l1:
        #     current.next = l1
        # else:
        #     current.next = l2
        current.next = l1 or l2
        return res.next

    # def removeDuplicates(self, nums: List[int]) -> int:
    #     res = 0
    #     for i in range(len(nums)):
    #         if i == len(nums)-1 or nums[i] == nums[i+1]:
    #             nums[res] = nums[i]
    #             res = res + 1
    #     return res

    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        for i in range(len(nums)):
            if i == len(nums) - 1 or nums[i] != nums[i + 1]:
                nums[res] = nums[i]
                res = res + 1
        return res

    def testparam(self, arr: list) -> int:
        return "sss"

    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        for i in range(nums.count(val)):
            nums.remove(val)
        return len(nums)

    def strStr(self, haystack: str, needle: str) -> int:
        return haystack.find(needle)

    def threeSum(self, nums):
        """
        15. 3Sum
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            if i == 0 or nums[i] != nums[i-1]:
                head, tail = i+1, len(nums) - 1
                while head < tail:
                    if nums[head] + nums[tail] == -nums[i]:
                        res.append([nums[i], nums[head], nums[tail]])
                        while head < tail and nums[head] == nums[head+1]:
                            head = head + 1
                        while head < tail and nums[tail] == nums[tail-1]:
                            tail = tail - 1
                        head = head + 1
                        tail = tail - 1
                    elif nums[head] + nums[tail] < -nums[i]:
                        head = head + 1
                    else:
                        tail = tail - 1
        return res
