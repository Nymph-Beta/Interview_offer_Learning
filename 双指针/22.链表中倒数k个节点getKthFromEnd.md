#### 剑指offer22.链表中倒数最后k个结点

```
输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
如果该链表长度小于k，请返回一个长度为 0 的链表。


数据范围：
0≤n≤10^5
0≤ai≤10^9 
0≤k≤10^9
 
要求：空间复杂度 O(n)，时间复杂度 O(n)
进阶：空间复杂度 O(1)，时间复杂度 O(n)
```

#### 题解

```
设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。

ListNode firstPointer = head; 
        ListNode secondPointer = head;

        for (int i = 0; i < x; i++) {
            if (firstPointer == null){
                return null;
            }   
            firstPointer = firstPointer.next;
        }

    	// 同时移动两个指针，直到第一个指针到达尾部
        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
```
