#### 剑指offer23.反转链表

```
给定一个单链表的头结点pHead(该头节点是有值的，长度为n，反转该链表后，返回新链表的表头。

数据范围： 
0≤n≤1000
要求：空间复杂度 O(1) ，时间复杂度 O(n) 。

如当输入链表{1,2,3}时，
经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。

示例1
输入：{1,2,3}
返回值：{3,2,1}

示例2
输入：{}
返回值：{}
说明：空链表则输出空   
```

#### 方法一:迭代(头插法)

#### 方法二:递归

```

1.终止条件：当 cur 为空，则返回尾节点 pre （即反转链表的头节点）；
2.递归后继节点，记录返回值（即反转链表的头节点）为 res ；
3.修改当前节点 cur 引用指向前驱节点 pre ；
4.返回反转链表的头节点 res ；

 private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
  

```

#### 拓展：链表对折：

##### 一般思路：

1.**找到中点并分割链表**

我们使用快慢指针法找到链表的中点，并将链表分割为两部分

**2.反转后半部分**

将后半部分的链表反转

**3.交替合并两个链表**

将反转后的后半部分链表与前半部分交替合并。

```
public class FoldLinkedList {
  
    public ListNode fold(ListNode head) {
        if (head == null || head.next == null) return head;
      
        // Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
      
        // Split the linked list into two halves
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null;
      
        // Reverse the second half
        ListNode prev = null, curr = secondHalf;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        secondHalf = prev;
      
        // Merge the two halves alternately
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
          
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
          
            firstHalf = temp1;
            secondHalf = temp2;
        }
      
        return head;
    }
```

##### 优化：

1. 使用快慢指针找到链表的中点。
2. 不反转后半部分，而是使用栈将后半部分的节点存储起来，这样从栈中弹出的节点顺序就是反转的顺序。
3. 将从栈中弹出的节点插入到前半部分的适当位置。

   ```
   public class FoldLinkedList {
     
       public ListNode fold(ListNode head) {
           if (head == null || head.next == null) return head;

           // Find the middle of the linked list
           ListNode slow = head, fast = head;
           while (fast != null && fast.next != null) {
               slow = slow.next;
               fast = fast.next.next;
           }

           // Push the second half nodes onto stack
           Stack<ListNode> stack = new Stack<>();
           while (slow != null) {
               stack.push(slow);
               slow = slow.next;
           }

           // Merge the two halves alternately
           ListNode current = head;
           while (!stack.isEmpty()) {
               ListNode temp = current.next;
               ListNode nodeFromStack = stack.pop();

               if (temp == nodeFromStack) break; // Break when we reach the middle

               current.next = nodeFromStack;
               nodeFromStack.next = temp;
               current = temp;
           }

           if (current != null) {
               current.next = null; // Set the next of the last node in the first half to null
           }
         
           return head;
       }
   ```
