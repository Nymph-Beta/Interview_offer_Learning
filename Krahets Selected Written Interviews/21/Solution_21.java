/**
 * Merges two ascending linked tables into a new ascending linked table and returns it. 
 * The new linked table is formed by splicing all the nodes of the given two linked tables.
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

class Solution{

    public ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        if(list1 != null){
            prev.next = list1;
        }else{
            prev.next = list2;
        }

        return dummy.next;
    }
}

class Solution_21{
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 创建 list1 链表
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // 创建 list2 链表
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // 合并链表
        ListNode mergedList = solution.mergeTwoList(list1, list2);

        // 输出合并后的链表
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}