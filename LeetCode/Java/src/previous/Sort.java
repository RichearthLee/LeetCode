package previous;

/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月15日
 */
public class Sort {
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }
 
    public void quickSort(ListNode head, ListNode end) {
        if(head != end) {
            ListNode partion = partion(head);
            quickSort(head, partion);
            quickSort(partion.next, end);
        }
    }
 
    public ListNode partion(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if(fast.val < head.val) {
                slow = slow.next;
                fast.val = slow.val ^ fast.val ^ (slow.val = fast.val);
            }
            fast = fast.next;
        }
        slow.val = head.val ^ slow.val ^ (head.val = slow.val);
        return slow;
    }

    /**
     *
     * @param
     * @return
     */
    public int[] quickSortRecursion(int[] arr, int s , int e){
        if(s < e){
            int base = getpart(arr, s, e);
            quickSortRecursion(arr, s, base-1);
            quickSortRecursion(arr, base+1, e);
        }
        return arr;
    }
    public int getpart(int[] arr, int s, int e){
        int num = arr[s];
        while(s < e){
            while (s < e && num < arr[e]){
                e--;
            }
            if(s < e){
                arr[s] = arr[e];
            }
            while (s < e && num > arr[s]){
                s++;
            }
            if(s < e){
                arr[e] = arr[s];
            }
        }
        arr[s] = num;
        return s;
    }
}