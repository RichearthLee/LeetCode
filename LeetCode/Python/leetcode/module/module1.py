from data_structure import ListNode

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
    
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)
        cur = head
        flag = 0
        while(l1 != None or l2 != None or flag == 1):
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
            node.val = (num + flag)%10
            flag = (num + flag)/10
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
            carry, val = divmod(v1+v2+carry, 10)
            n.next = ListNode(val)
            n = n.next
        return root.next


