class ListNode {
    int val;
    ListNode next;

    ListNode(int var1) {
        this.val = var1;
    }
}
class Solution{
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

public class Solution_237 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 创建 list 链表
        ListNode list = new ListNode(4);
        list.next = new ListNode(5);
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(9);

        // 删除节点
        solution.deleteNode(list.next);

        // 输出删除后的链表
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
