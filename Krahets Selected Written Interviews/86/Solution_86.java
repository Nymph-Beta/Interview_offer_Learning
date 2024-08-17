/** Merges two ascending linked tables into a new ascending linked table and returns it. 
 * The new linked table is formed by splicing all the nodes of the given two linked tables.
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int var1) {
        this.val = var1;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x){
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode prev1 = dummy1;
        ListNode prev2 = dummy2;

        while(head != null){
            if(head.val < x){
                prev1.next = head;
                prev1 = prev1.next;
            }else{
                prev2.next = head;
                prev2 = prev2.next;
            }
            head = head.next;
        }
        prev1.next = dummy2.next;
        prev2.next = null;

        return dummy1.next;
    }
}

/**
 * Solution_86
 */
public class Solution_86 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 创建 list 链表
        ListNode list = new ListNode(1);
        list.next = new ListNode(4);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(2);

        // 分隔链表
        ListNode partitionedList = solution.partition(list, 3);

        // 输出分隔后的链表
        while (partitionedList != null) {
            System.out.print(partitionedList.val + " ");
            partitionedList = partitionedList.next;
        }
    }
    
}

