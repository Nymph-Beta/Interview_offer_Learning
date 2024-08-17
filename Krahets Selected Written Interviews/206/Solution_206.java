class Solution_206 {
    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode reversedList = solution.reverseList(list);

  
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int var1) {
        this.val = var1;
    }
}

class Solution {
    public ListNode reverseList(ListNode head){
    //     if (var1 == null) {
    //      return null;
    //     } else {
    //         ListNode var2 = null;

    //         ListNode var4;
    //         for(ListNode var3 = var1; var3 != null; var3 = var4) {
    //             var4 = var3.next;
    //             var3.next = var2;
    //             var2 = var3;
    //         }

    //         return var2;
    //   }
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
